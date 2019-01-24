package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class CommandSeleniumElementSendKeys extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(CommandSeleniumElementSendKeys.class);

    protected String sendKeys;

    public CommandSeleniumElementSendKeys(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement, String sendKeys) {
        super(appSeleniumElement, seleniumElement);
        this.sendKeys = sendKeys;
    }

    @Override
    public <T> T execute() {
        T link = null;
        logger.debug("CommandSeleniumElementSendKeys <T> T execute() null " + sendKeys);
        Expression<T> expression = (webElement) -> {webElement.sendKeys(sendKeys); return link;};
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
