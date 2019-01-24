package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class SeleniumElementGetAttribute extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementGetAttribute.class);

    protected String attributeName;

    public SeleniumElementGetAttribute(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement, String attributeName) {
        super(appSeleniumElement, seleniumElement);
        this.attributeName = attributeName;
    }

    @Override
    public <T> T execute() {
        logger.debug("SeleniumElementGetAttribute <T> T execute() String " + attributeName);
        Expression<T> expression = (webElement) -> (T)webElement.getAttribute(attributeName);
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
