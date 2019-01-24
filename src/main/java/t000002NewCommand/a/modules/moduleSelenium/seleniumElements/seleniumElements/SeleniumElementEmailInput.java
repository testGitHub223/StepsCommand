package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumElementEmailInput extends SeleniumElementAbstract {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementEmailInput.class);

    public SeleniumElementEmailInput() {
        super("//input[@name = \"email\"]", "Блок авторизации");
    }
}
