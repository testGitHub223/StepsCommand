package t000002NewCommand.a.modules.moduleSelenium.browsers.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.core.ICommand;
import t000002NewCommand.a.modules.moduleSelenium.IAppBrowser;


public abstract class CommandBrowser implements ICommand {

    protected static Logger logger = LoggerFactory.getLogger(CommandBrowser.class);

    protected IAppBrowser appBrowser;

    public CommandBrowser(IAppBrowser appBrowser) {
        this.appBrowser = appBrowser;
    }

}
