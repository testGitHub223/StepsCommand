package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SeleniumElementAbstract implements ISeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementAbstract.class);

    protected String elementXpath;
    protected String elementName;

    public SeleniumElementAbstract(String elementXpath, String elementName) {
        this.elementXpath = elementXpath;
        this.elementName = elementName;
    }

    @Override
    public String getElementFullXpath() {
        return elementXpath;
    }

    @Override
    public String getElementFullName() {
        return elementName;
    }

}
