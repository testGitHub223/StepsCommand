package t000002NewCommand.a.core.coreUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.core.coreServerConfig.IServerConfig;

public class AuthEmailPage extends AbstrPage {

    protected static Logger logger = LoggerFactory.getLogger(AuthEmailPage.class);

//    public AuthEmailPage(){
//        super("/auth/emai", "страница авторизации Емейл");
//    }

    public AuthEmailPage(IServerConfig cfg){
        super(cfg);
        pageName = "страница авторизации Емейл";
        pageURL = "/auth/email";
        parametrURL = "";
    }

}