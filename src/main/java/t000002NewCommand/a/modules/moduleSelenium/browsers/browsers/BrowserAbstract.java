package t000002NewCommand.a.modules.moduleSelenium.browsers.browsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BrowserAbstract implements IBrowser {

    protected static Logger logger = LoggerFactory.getLogger(BrowserAbstract.class);

    protected String browserName;

    @Override
    public String getBrowserName() {
        return browserName;
    }
}
