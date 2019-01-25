package t000002NewCommand.a.bg.seleniumElements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementAbstract;

public class SeleniumElementPasswordInput extends SeleniumElementAbstract {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementPasswordInput.class);

    public SeleniumElementPasswordInput() {
        super("//input[@name = \"password\"]", "Поле ввода пароля");
    }
}