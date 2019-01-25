package t000002NewCommand.a.bg.seleniumElements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementAbstract;

public class SeleniumElementEmailInput extends SeleniumElementAbstract {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementEmailInput.class);

    public SeleniumElementEmailInput() {
        super("//input[@name = \"email\"]", "Блок авторизации");
    }
}
