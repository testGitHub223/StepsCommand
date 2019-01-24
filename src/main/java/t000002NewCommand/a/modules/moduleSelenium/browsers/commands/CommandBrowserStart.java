package t000002NewCommand.a.modules.moduleSelenium.browsers.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.modules.moduleSelenium.IAppBrowser;
import t000002NewCommand.a.core.coreUrl.IPage;

public class CommandBrowserStart extends CommandBrowser {

    private static Logger logger = LoggerFactory.getLogger(CommandBrowserStart.class);

    protected IPage page;

    public CommandBrowserStart(IAppBrowser appBrowser, IPage page) {
        super(appBrowser);
        this.page = page;
    }

    @Override
    public <T> T execute() {
        T link = null;

        logger.debug("Пытаемся стартануть браузер со страницы " + page.getFullPageURL());         //--debug--
        this.appBrowser.getDriver().get(page.getFullPageURL());
        logger.debug("Cтартанули браузер со страницы " + page.getFullPageURL());         //--debug--

        return link;
    }

}
