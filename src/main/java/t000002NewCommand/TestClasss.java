package t000002NewCommand;

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

import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementEmailInput;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementMenuName;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementPasswordInput;
import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.SeleniumElementSubmitButton;
import t000002NewCommand.a.core.coreServerConfig.IServerConfig;
import t000002NewCommand.a.core.coreUrl.AuthEmailPage;
import t000002NewCommand.a.core.coreUrl.IPage;

import java.util.ArrayList;
import java.util.List;

public class TestClasss {

    private static Logger logger = LoggerFactory.getLogger(TestClasss.class);

    protected static IServerConfig cfg;
    protected static IPage page;
    protected static IApp app;
    protected static IBrowser browser;

    @Before
    public void setUp() {
        ConfigFactory.setProperty("mypath", "demo");
        cfg = ConfigFactory.create(t000002NewCommand.a.core.coreServerConfig.IServerConfig.class);

        page = new AuthEmailPage(cfg);
        app = new App();
        browser = new BrowserChrome();
        ICommand commandCreateBrowser = new CommandBrowserCreate(app, browser);
        commandCreateBrowser.execute();
        ICommand commandStartBrowser = new CommandBrowserStart(app, page);
        commandStartBrowser.execute();

    }

    @After
    public void tirDown() {
        app.closeDriver();
    }

    // Проверка вывода собщения "Некорректный адрес электронной почты"
    @Test
    public void test001() {


        ISeleniumElement emailInput = new SeleniumElementEmailInput();
        ISeleniumElement passwordInput = new SeleniumElementPasswordInput();
        ISeleniumElement submitButton = new SeleniumElementSubmitButton();
        ISeleniumElement menuName = new SeleniumElementMenuName();

        List<ICommand> ICommands = new ArrayList<>();

        ICommands.add(new CommandSeleniumElementClick(app, emailInput));
        ICommands.add(new CommandSeleniumElementGetText(app, emailInput));
        ICommands.add(new CommandSeleniumElementSendKeys(app, emailInput, "devbg72+client11@gmail.com"));

        ICommands.add(new CommandSeleniumElementSendKeys(app, passwordInput, "12345678"));
        ICommands.add(new CommandSeleniumElementClick(app, submitButton));



        for (int i = 0; i < ICommands.size(); i++) {
            logger.info(ICommands.get(i).execute());
            //ICommands.get(i).execute();
        }
        

        logger.info((new CommandSeleniumElementGetText(app, menuName)).execute());

    }
}
