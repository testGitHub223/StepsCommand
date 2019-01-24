package t000002NewCommand.a.modules.moduleSelenium.browsers.browsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserChrome extends BrowserAbstract {

    protected static Logger logger = LoggerFactory.getLogger(BrowserChrome.class);

    public BrowserChrome() {
        this.browserName = "chrome";
    }

}
