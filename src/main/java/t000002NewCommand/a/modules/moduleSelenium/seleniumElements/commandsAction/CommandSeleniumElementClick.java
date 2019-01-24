package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;


public class CommandSeleniumElementClick extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(CommandSeleniumElementClick.class);

    public CommandSeleniumElementClick(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement) {
        super(appSeleniumElement, seleniumElement);
    }

    @Override
    public <T> T execute() {
        T link = null;
        logger.debug("CommandSeleniumElementClick <T> T execute() null");
        Expression<T> expression = (webElement) -> {webElement.click(); return link;};
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
