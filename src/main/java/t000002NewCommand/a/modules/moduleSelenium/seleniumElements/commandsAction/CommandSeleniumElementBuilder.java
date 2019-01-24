package t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction;

import t000002NewCommand.a.core.ICommand;
import t000002NewCommand.a.modules.moduleSelenium.IAppGetableDriver;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;

public class CommandSeleniumElementBuilder {


    public static ICommand CreateCommand(String commandType, IAppGetableDriver appSeleniumElement, ISeleniumElement seleniumElement ){
        ICommand command = null;

        switch (commandType){
            case "click":
                command = new CommandSeleniumElementClick(appSeleniumElement, seleniumElement);
                break;
            case "clear":
                command = new CommandSeleniumElementClear(appSeleniumElement, seleniumElement);
                break;
            case "submit":
                command = new CommandSeleniumElementSubmit(appSeleniumElement, seleniumElement);
                break;
            case "getText":
                command = new CommandSeleniumElementGetText(appSeleniumElement, seleniumElement);
                break;
                ////////////////////////////////////////
            case "sendKeys":
                command = new CommandSeleniumElementSendKeys(appSeleniumElement, seleniumElement, "");
                break;
        }



        return command;

    }
}
