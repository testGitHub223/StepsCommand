package t000002NewCommand.a.core.coreUrl;

public interface IPage {

    // получаем название страницы
    String getPageName();

    // получаем домен страницы
    String getDomain();

    // получаем адрес страницы
    String getPageURL();

    // параметр URL
    String getParametrURL();
    // список параметров URL

    // возможно добавить
    String getFullPageURL();

}
