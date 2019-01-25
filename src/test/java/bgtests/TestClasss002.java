package bgtests;


import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.core.IApp;
import t000002NewCommand.a.core.ICommand;

import t000002NewCommand.a.modules.moduleSelenium.browsers.commands.CommandBrowserStart;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.CommandSeleniumElementClick;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.CommandSeleniumElementGetText;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.CommandSeleniumElementSendKeys;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;

import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementEmailInput;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementMenuName;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementPasswordInput;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementSubmitButton;
import t000002NewCommand.a.core.coreServerConfig.IServerConfig;
import t000002NewCommand.a.core.coreUrl.AuthEmailPage;
import t000002NewCommand.a.core.coreUrl.IPage;


import java.util.ArrayList;
import java.util.List;

public class TestClasss002 {

    private static Logger logger = LoggerFactory.getLogger(TestClasss002.class);

    protected static IPage page;
    protected static IApp app;
    protected static IServerConfig cfg;


    @Before
    public void setUp() {

        ConfigFactory.setProperty("mypath", "demo");
        cfg = ConfigFactory.create(t000002NewCommand.a.core.coreServerConfig.IServerConfig.class);

        page = new AuthEmailPage(cfg);
        //app = AppSeleniumMainBuilder.createDriver("chrome");
        ICommand command = new CommandBrowserStart(app, page);
        command.execute();

    }

    @After
    public void tirDown() {
        app.closeDriver();
    }

    // Проверка вывода собщения "Некорректный адрес электронной почты"
    @Test
    public void test001() {

        ISeleniumElement seleniumElementEmail = new SeleniumElementEmailInput();
        ISeleniumElement seleniumElementPassword = new SeleniumElementPasswordInput();
        ISeleniumElement seleniumElementSubmitButton = new SeleniumElementSubmitButton();
        ISeleniumElement seleniumElementMenuName = new SeleniumElementMenuName();

        List<ICommand> commands = new ArrayList<>();

//        commandsAction.add(new CommandSeleniumElementClick(appSelenium, seleniumElementEmail));
        commands.add(new CommandSeleniumElementSendKeys(app, seleniumElementEmail, "devbg72+client11@gmail.com"));
        commands.add(new CommandSeleniumElementSendKeys(app, seleniumElementPassword, "12345678"));
        commands.add(new CommandSeleniumElementClick(app, seleniumElementSubmitButton));
//        commandsAction.add(new CommandSeleniumElementGetText(appSelenium, seleniumElementMenuName));
//        ICommands.add(new CommandSeleniumElementGetText(appSelenium, seleniumElement));


        for (int i = 0; i < commands.size(); i++) {
           logger.info((String) commands.get(i).execute());
        }

        logger.info((new CommandSeleniumElementGetText(app, seleniumElementMenuName).execute()));

    }
}
