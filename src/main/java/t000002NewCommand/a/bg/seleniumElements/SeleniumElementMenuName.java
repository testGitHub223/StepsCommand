package t000002NewCommand.a.bg.seleniumElements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementAbstract;

public class SeleniumElementMenuName extends SeleniumElementAbstract {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementMenuName.class);

    public SeleniumElementMenuName() {
        super("//span[@class = \"menu-drop-down__name\"]", "Меню с именем");
    }
}