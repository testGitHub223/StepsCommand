package t000002NewCommand.a.modules.moduleSelenium.browsers.commands;

import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppBrowser;

public class CommandBrowserSetDemention extends CommandBrowser {

    private static Logger logger = LoggerFactory.getLogger(CommandBrowserSetDemention.class);

    protected Dimension dimension;

    public CommandBrowserSetDemention(IAppBrowser appBrowser, Dimension dimension) {
        super(appBrowser);
        this.dimension = dimension;
    }

    @Override
    public <T> T execute() {
        T link = null;

        logger.debug("Пытаемся установить разрешение браузера: " + dimension);         //--debug--
        if (this.appBrowser != null) {
            logger.debug("Установливаем разрешение браузера: " + dimension);           //--debug--
            this.appBrowser.getDriver().manage().window().setSize(dimension);
            logger.debug("Установили разрешение браузера: " + dimension);              //--debug--
        }
        logger.debug("Сохранили разрешение браузера в настройках: " + dimension);      //--debug--

        return link;
    }

}
