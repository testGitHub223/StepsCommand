package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression.Expression;

public class SeleniumElementFindElements extends CommandSeleniumElement {

    private static Logger logger = LoggerFactory.getLogger(SeleniumElementFindElements.class);

    protected By by;

    public SeleniumElementFindElements(IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement, By by) {
        super(appSeleniumElement, seleniumElement);
        this.by = by;
    }

    @Override
    public <T> T execute() {
        logger.debug("SeleniumElementFindElements <T> T execute() List<WebElement> " + by);
        Expression<T> expression = (webElement) -> (T)webElement.findElements(by);
        return waitingAction999(expression, this.appSeleniumElement, waitingTimeMillis, deltaToWaitMillis);
    }

}
