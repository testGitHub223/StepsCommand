package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class CommandSeleniumElementClear extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(CommandSeleniumElementClear.class);

    public CommandSeleniumElementClear(IAppGetableDriver appGetableDriver, ISeleniumElement seleniumElement) {
        super(appGetableDriver, seleniumElement);
    }

    @Override
    public <T> T execute() {
        T link = null;
        logger.debug("CommandSeleniumElementClear <T> T execute() null");
        Expression<T> expression = (webElement) -> {webElement.clear(); return link;};
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
