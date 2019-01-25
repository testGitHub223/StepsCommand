package t000002NewCommand.a.bg.seleniumElements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementAbstract;

public class SeleniumElementSubmitButton extends SeleniumElementAbstract {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementSubmitButton.class);

    public SeleniumElementSubmitButton() {
        super("//button[@class = \"button button_color_primary\"][@type = \"submit\"]", "Кнопка Войти");
    }
}