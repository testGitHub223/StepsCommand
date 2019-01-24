package t000002NewCommand.a.modules.moduleSelenium.browsers.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppBrowser;
import t000002NewCommand.a.modules.moduleSelenium.browsers.browsers.IBrowser;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class CommandBrowserCreate extends CommandBrowser {

    private static Logger logger = LoggerFactory.getLogger(CommandBrowserCreate.class);

    protected IBrowser browser;
    protected int implicitlyWait = 0;

    public CommandBrowserCreate(IAppBrowser appBrowser, IBrowser browser) {
        super(appBrowser);
        this.browser = browser;
    }

    public CommandBrowserCreate(IAppBrowser appBrowser, IBrowser browser, int implicitlyWait) {
        super(appBrowser);
        this.browser = browser;
        this.implicitlyWait = implicitlyWait;
    }

    @Override
    public <T> T execute() {
        T link = null;

        logger.debug("Пытаемся создать браузер " + browser.getBrowserName());         //--debug--

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // Для включения просмотра по VNC client через веб-часть.
        capabilities.setCapability("screenResolution", "1280x1024x24"); // Ширина, высота, глубина цвета
        capabilities.setCapability("enableVideo", true); //Включить запись видео.
        capabilities.setCapability("videoName", "my-cool-video.mp4"); // Название видео записи
        capabilities.setCapability("videoScreenSize", "1024x768"); // Разрешение видео.
        capabilities.setCapability("videoFrameRate", 24); // Кол-во кадров/сек.
        capabilities.setCapability("browserName", "myCoolTestName"); // Кастомное название теста.
        capabilities.setCapability("sessionTimeout", 30); // Время для удаления контейнера в случаи простой. (Желательно не использовать)
        capabilities.setCapability("timeZone", "Europe/Moscow"); // Установка времени. Если не указано в контейнере (нам не нужно).
        //capabilities.setCapability("dnsServers", new String[]{"192.168.0.1", "192.168.0.2"}); // Если необходимо пусть через определенные DNS-сервера.
        capabilities.setBrowserName("chrome"); //Браузер в котором нужно проверять.
        capabilities.setVersion("68.0"); //Версия браузера.

        //typeBrowser = "remote";
        WebDriver driver;
        switch (browser.getBrowserName()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            case "remote":
                //String urlRWD = "http://192.168.2.192:4444/wd/hub/";
                //String urlRWD = "http://127.0.0.1:4444/wd/hub/";
                //String urlRWD = "http://192.168.2.192:4444/wd/hub/";

                String urlRWD = "http://" + System.getenv("hostRemote") + ":4444/wd/hub/";
                logger.info("hostRemote [" + urlRWD + "]");
                try {
                    driver = new RemoteWebDriver(URI.create(urlRWD).toURL(), capabilities); // Урл для запуска где стоит хост-машина, а так же надстройки определенные выше.
                    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector()); //Необходимо использовать если загружаете файлы.
                } catch (MalformedURLException e) {
                    logger.error("Не удалось распарсить URL RemoteWebDriver - " + urlRWD);
                    e.printStackTrace();
                    throw new NullPointerException();
                }
                break;
            default:
                throw new IllegalArgumentException("Не знаю такого браузера" + browser.getBrowserName());
        }
        if (implicitlyWait > 0) {
            driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.MILLISECONDS);
        }
        //return new AppSeleniumElementSeleniumMain(driver);

        appBrowser.setDriver(driver);

        logger.debug("Создали браузер " + browser.getBrowserName());         //--debug--

        return link;
    }

}
