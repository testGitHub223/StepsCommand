package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class SeleniumElementFindElement extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementFindElement.class);

    protected By by;

    public SeleniumElementFindElement(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement, By by) {
        super(appSeleniumElement, seleniumElement);
        this.by = by;
    }

    @Override
    public <T> T execute() {
        logger.debug("SeleniumElementFindElement <T> T execute() WebElement " + by);
        Expression<T> expression = (webElement) -> (T)webElement.findElement(by);
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
