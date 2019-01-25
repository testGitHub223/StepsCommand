package bgtests;


import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.core.App;
import t000002NewCommand.a.core.IApp;
import t000002NewCommand.a.core.ICommand;
import t000002NewCommand.a.modules.moduleSelenium.browsers.browsers.IBrowser;
import t000002NewCommand.a.modules.moduleSelenium.browsers.browsers.BrowserChrome;
import t000002NewCommand.a.modules.moduleSelenium.browsers.commands.CommandBrowserCreate;
import t000002NewCommand.a.modules.moduleSelenium.browsers.commands.CommandBrowserStart;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.CommandSeleniumElementClick;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.CommandSeleniumElementGetText;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.commandsAction.CommandSeleniumElementSendKeys;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;

import t000002NewCommand.a.bg.seleniumElements.SeleniumElementEmailInput;
import t000002NewCommand.a.bg.seleniumElements.SeleniumElementMenuName;
import t000002NewCommand.a.bg.seleniumElements.SeleniumElementPasswordInput;
import t000002NewCommand.a.bg.seleniumElements.SeleniumElementSubmitButton;
import t000002NewCommand.a.core.coreServerConfig.IServerConfig;
import t000002NewCommand.a.core.coreUrl.AuthEmailPage;
import t000002NewCommand.a.core.coreUrl.IPage;

import java.util.ArrayList;
import java.util.List;

public class TestClasss003 {

    private static Logger logger = LoggerFactory.getLogger(TestClasss003.class);

    protected static IServerConfig cfg;
    protected static IPage page;
    protected static IBrowser browser;
    protected static IApp app;


    @Before
    public void setUp() {

        ConfigFactory.setProperty("mypath", "demo");
        cfg = ConfigFactory.create(IServerConfig.class);

        page = new AuthEmailPage(cfg);
        browser = new BrowserChrome();
        app = new App();

        new CommandBrowserCreate(app, browser).execute();

//        app = AppSeleniumMainBuilder.createDriver("chrome");
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

        //commandsAction.add(new CommandSeleniumElementClick(app, seleniumElementEmail));
        commands.add(new CommandSeleniumElementSendKeys(app, seleniumElementEmail, "devbg72+client11@gmail.com"));
        commands.add(new CommandSeleniumElementSendKeys(app, seleniumElementPassword, "12345678"));
        commands.add(new CommandSeleniumElementClick(app, seleniumElementSubmitButton));
//        commandsAction.add(new CommandSeleniumElementGetText(app, seleniumElementMenuName));
//        ICommands.add(new CommandSeleniumElementGetText(app, seleniumElement));


        for (int i = 0; i < commands.size(); i++) {
           logger.info(commands.get(i).execute());
        }

        logger.info((new CommandSeleniumElementGetText(app, seleniumElementMenuName).execute()));

    }
}
