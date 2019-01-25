//package t000002NewCommand;
//
//
//import org.aeonbits.owner.ConfigFactory;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import t000002NewCommand.a.core.ICommand;
//import t000002NewCommand.a.coreSelenium.IAppSelenium;
//import t000002NewCommand.a.modules.moduleSelenium.IAppBrowser;
//import t000002NewCommand.a.modules.moduleSelenium.browsers.browsers.IBrowser;
//import t000002NewCommand.a.modules.moduleSelenium.browsers.browsers.BrowserChrome;
//import t000002NewCommand.a.coreSeleniumDriver.commandsAction.CommandBrowserCreate;
//import t000002NewCommand.a.coreSeleniumDriver.commandsAction.CommandBrowserStart;
//import t000002NewCommand.a.modules.moduleSelenium.seleniumElements.seleniumElements.ISeleniumElement;
//import t000002NewCommand.a.coreSeleniumElement.commandsAction.CommandSeleniumElementClick;
//import t000002NewCommand.a.coreSeleniumElement.commandsAction.CommandSeleniumElementGetText;
//import t000002NewCommand.a.coreSeleniumElement.commandsAction.CommandSeleniumElementSendKeys;
//import t000002NewCommand.a.bg.seleniumElements.SeleniumElementEmailInput;
//import t000002NewCommand.a.bg.seleniumElements.SeleniumElementMenuName;
//import t000002NewCommand.a.bg.seleniumElements.SeleniumElementPasswordInput;
//import t000002NewCommand.a.bg.seleniumElements.SeleniumElementSubmitButton;
//import t000002NewCommand.a.core.coreServerConfig.IServerConfig;
//import t000002NewCommand.a.core.coreUrl.AuthEmailPage;
//import t000002NewCommand.a.core.coreUrl.IPage;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestClasss004testJson {
//
//    private static Logger logger = LoggerFactory.getLogger(SeleniumElementSubmitButton.class);
//
//    protected static IServerConfig cfg;
//    protected static IPage page;
//    protected static IBrowser browser;
//
//
//
//    @Before
//    public void setUp() {
//
//        ConfigFactory.setProperty("mypath", "demo");
//        cfg = ConfigFactory.create(IServerConfig.class);
//
//
//
//        page = new AuthEmailPage(cfg);
//        browser = new BrowserChrome("chrome");
//        new CommandBrowserCreate(appSelenium, browser).execute();
//
//        //appSelenium = AppSeleniumMainBuilder.createDriver("chrome");
//        ICommand command = new CommandBrowserStart((IAppBrowser) appSelenium, page);
//        command.execute();
//
//    }
//
//    @After
//    public void tirDown() {
//        appSelenium.closeDriver();
//    }
//
//    // Проверка вывода собщения "Некорректный адрес электронной почты"
//    @Test
//    public void test001() {
//
//        ISeleniumElement seleniumElementEmail = new SeleniumElementEmailInput();
//        ISeleniumElement seleniumElementPassword = new SeleniumElementPasswordInput();
//        ISeleniumElement seleniumElementSubmitButton = new SeleniumElementSubmitButton();
//        ISeleniumElement seleniumElementMenuName = new SeleniumElementMenuName();
//
//        List<ICommand> commandsAction = new ArrayList<>();
//
//        //commandsAction.add(new CommandSeleniumElementClick(appSelenium, seleniumElementEmail));
//        commandsAction.add(new CommandSeleniumElementSendKeys(appSelenium, seleniumElementEmail, "devbg72+client11@gmail.com"));
//        commandsAction.add(new CommandSeleniumElementSendKeys(appSelenium, seleniumElementPassword, "12345678"));
//        commandsAction.add(new CommandSeleniumElementClick(appSelenium, seleniumElementSubmitButton));
////        commandsAction.add(new CommandSeleniumElementGetText(appSelenium, seleniumElementMenuName));
////        ICommands.add(new CommandSeleniumElementGetText(appSelenium, seleniumElement));
//
//
//        for (int i = 0; i < commandsAction.size(); i++) {
//           logger.info((String) commandsAction.get(i).execute());
//        }
//
//        logger.info((new CommandSeleniumElementGetText(appSelenium, seleniumElementMenuName).execute()));
//
//    }
//}
