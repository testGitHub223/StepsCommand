package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class SeleniumElementIsEnabled extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementIsEnabled.class);

    public SeleniumElementIsEnabled(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement) {
        super(appSeleniumElement, seleniumElement);
    }

    @Override
    public <T> T execute() {
        logger.debug("SeleniumElementIsEnabled <T> T execute() Boolean");
        Expression<T> expression = (webElement) -> (T)(Boolean)webElement.isEnabled();
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
