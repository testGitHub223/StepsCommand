package t000002NewCommand.a.core.coreUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import t000002NewCommand.a.core.coreServerConfig.IServerConfig;

public abstract class AbstrPage implements IPage{

    protected static Logger logger = LoggerFactory.getLogger(AbstrPage.class);

    protected String pageName;
    protected String domain;
    protected String pageURL;
    protected String parametrURL;



    public AbstrPage(){
        this("", "");
    }

    public AbstrPage(String pageURL, String pageName){
        this.pageURL = pageURL;
        this.pageName = pageName;
    }

    public AbstrPage(IServerConfig cfg){
//        this.pageName = "";
        this.domain = cfg.serverHostname();
//        this.pageURL = "";
//        this.parametrURL = "";
    }

    // получаем название страницы
    @Override
    public String getPageName(){
        return pageName;
    }

    // получаем домен страницы
    @Override
    public String getDomain(){
        return domain;
    }

    // получаем адрес страницы
    @Override
    public String getPageURL(){
        return pageURL;
    }
    // параметр URL
    @Override
    public String getParametrURL(){
        return parametrURL;
    }

    // список параметров URL

    // возможно добавить
    @Override
    public String getFullPageURL(){
        if (parametrURL != null) {
            return domain + pageURL + parametrURL;
        }
        return domain + pageURL;
    }

}
