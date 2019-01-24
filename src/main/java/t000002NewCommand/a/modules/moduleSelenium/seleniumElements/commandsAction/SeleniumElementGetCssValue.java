package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class SeleniumElementGetCssValue extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementGetCssValue.class);

    protected String propertyName;

    public SeleniumElementGetCssValue(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement, String propertyName) {
        super(appSeleniumElement, seleniumElement);
        this.propertyName = propertyName;
    }

    @Override
    public <T> T execute() {
        logger.debug("SeleniumElementGetCssValue <T> T execute() String " + propertyName);
        Expression<T> expression = (webElement) -> (T)webElement.getCssValue(propertyName);
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
