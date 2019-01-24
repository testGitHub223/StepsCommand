package t000002NewCommand.a.core;

import org.openqa.selenium.WebDriver;

public class App implements IApp {

    protected WebDriver webDriver;

    public WebDriver getDriver(){
        return webDriver;
    }

    @Override
    public void setDriver(WebDriver driver) {
        webDriver = driver;
    }

    @Override
    public void closeDriver() {
        webDriver.close();
    }
}
