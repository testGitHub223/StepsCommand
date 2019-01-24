package t000002NewCommand.a.core.coreServerConfig;


import org.aeonbits.owner.Config;
import org.openqa.selenium.Dimension;
import t000002NewCommand.a.core.coreServerConfig.converters.DimensionConverter;


@Config.Sources({ "classpath:resources/${mypath}.properties" })
public interface IServerConfig extends Config {

    @Key("server.hostname")
    String serverHostname();


    @Key("driver.typeBrowser")
    @DefaultValue("chrome")
    String driverTypeBrowser();

    @Key("driver.dimension")
    @ConverterClass(DimensionConverter.class)
    Dimension driverDimension();



    @Key("fileSystem.driveToSaveData")
    String fileSystemDriveToSaveData();

    @Key("fileSystem.folderNameToSaveData")
    String fileFolderNameToSaveData();

    @Key("fileSystem.folderNameToSaveAction")
    String fileFolderNameToSaveAction();

    @Key("fileSystem.folderNameToSaveWordReport")
    String fileFolderNameToSaveWordReport();

    @Key("fileSystem.fileNameWordReport")
    String fileFileNameWordReport();



    @Key("log.isLogSystem")
    boolean logIsLogSystem();

    @Key("log.isDoScreenshotAction")
    boolean logIsDoScreenshotAction();

    @Key("log.isLogAction")
    boolean logIsLogAction();

    @Key("log.isDoWordReport")
    boolean logIsDoWordReport();



    @Key("action.waitingTime")
    long actionWaitingTime();

    @Key("action.deltaTime")
    long actionDeltaTime();



    @Key("api.grantType")
    String apiGrantType();

    @Key("api.sadminMail")
    String apiSAdminMail();

    @Key("api.sadminPass")
    String apiSAdminPass();

    @Key("api.adminMail")
    String apiAdminMail();

    @Key("api.adminPass")
    String apiAdminPass();

    @Key("api.finance1Mail")
    String apiFinance1Mail();

    @Key("api.finance1Pass")
    String apiFinance1Pass();

    @Key("api.finance2Mail")
    String apiFinance2Mail();

    @Key("api.finance2Pass")
    String apiFinance2Pass();

    @Key("api.client1Mail")
    String apiClient1Mail();

    @Key("api.client1Pass")
    String apiClient1Pass();

    @Key("api.client2Mail")
    String apiClient2Mail();

    @Key("api.client2Pass")
    String apiClient2Pass();


    @Key("api.clientId")
    String apiClientId();

    @Key("api.clientsecret")
    String apiClientsecret();

    @Key("userAgent")
    String userAgent();


    @Key("charset")
    @DefaultValue("UTF-8")
    String charset();


    @Key("api.url.authorization")
    String apiUrlAuthorization();

}


