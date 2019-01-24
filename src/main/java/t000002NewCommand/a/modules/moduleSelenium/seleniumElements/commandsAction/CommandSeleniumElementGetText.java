package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class CommandSeleniumElementGetText extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(CommandSeleniumElementGetText.class);

    public CommandSeleniumElementGetText(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement) {
        super(appSeleniumElement, seleniumElement);
    }

    @Override
    public <T> T execute() {
        logger.debug("CommandSeleniumElementGetText <T> T execute() String");
        Expression<T> expression = (webElement) -> (T)webElement.getText();
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }
}
