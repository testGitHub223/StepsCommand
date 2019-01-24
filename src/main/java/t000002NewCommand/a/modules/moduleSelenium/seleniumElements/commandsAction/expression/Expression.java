package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.expression;

import org.openqa.selenium.WebElement;

public interface Expression<T>{
    //    void isEqual(WebElement webElement);
    T doAction(WebElement webElement);
}
