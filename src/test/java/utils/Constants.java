package utils;

public class Constants {
    public static final String URL_BASED = "https://emag.com";
    public static final String URL_BASED2 ="http://86.121.249.150:4999";
    //TODO -> SA SCHIMBI CA IN CONFIG PROPERTIES

    public static final String URL_LOGIN_EMAG ="https://auth.emag.ro/user/login";

    public static final String CONFIG_PATH ="";
    public static final String CONFIG_FILE ="config.properties";
    public static final String SCREENSHOT_PATH = "screenshots/";


    public static final String RESOURCES_PATH="src/test/resources/";
    public static final String DRIVERS_PATH = RESOURCES_PATH + "drivers/" ;
    public static final String EXTENSIONS_PATH = RESOURCES_PATH + "extensions/" ;
    public static final String DOWNLOAD_PATH ="downloads/";

    public static final String CURRENT_BROWSER="chrome";
    public static final String CURRENT_ENV ="local";

    //DB_CONNECTION
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_SCHEMA = "altenautomation";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "ADCtraining123";

    public static final String DB_JDBC = "jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_SCHEMA;


}
