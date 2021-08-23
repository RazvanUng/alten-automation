package utils;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

    public static String URL;
    public static String ENV;
    public static String BROWSER;
    public static boolean WEB_DRIVER_MANAGER;
    public static boolean HEADLESS_MODE;
    public static String DB_JDBC;
    public static String DB_USER;
    public static String DB_PASSWORD;


    public static void readConfigFile() {
        try
                (InputStream inputStream = new FileInputStream(Constants.CONFIG_PATH + Constants.CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String port = properties.getProperty("URL_PORT", "80");
            String hostname = properties.getProperty("ULR_HOSTNAME", "localhost");
            String proto = properties.getProperty("URL_PROTOCOL", "http");
            URL = proto + "://" + hostname + ":" + port + "/";
            ENV = properties.getProperty("CURRENT_ENV");
            BROWSER = properties.getProperty("RUN_BROWSER");
            WEB_DRIVER_MANAGER = Boolean.parseBoolean(properties.getProperty("WEB_DRIVER_MANAGER"));
            HEADLESS_MODE = Boolean.parseBoolean(properties.getProperty("START_HEADLESS"));
            String dbHost = properties.getProperty("DB_HOST", "localhost");
            String dbPort = properties.getProperty("DB_PORT", "3306");
            String dbSchema = properties.getProperty("DB_SCHEMA", "altenautomation");
            DB_USER = properties.getProperty("DB_USER", "root");
            DB_PASSWORD = properties.getProperty("DB_PASSWORD", "ADCtraining123");
            DB_JDBC ="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbSchema;


                    Log.info(URL);

        } catch (IOException exception) {
            // exception.printStackTrace();
            Log.error("File may not be found " + Constants.CONFIG_PATH + Constants.CONFIG_FILE);
            Log.fatal(GeneralUtils.stackTraceConvert(exception.getStackTrace()));


        }
    }

    public static void writeConfigFile(Map<String, String> configs) {
        try
                (OutputStream outputStream = new FileOutputStream(Constants.CONFIG_PATH + Constants.CONFIG_FILE)) {
            Properties properties = new Properties();
            //pentru fiecare cheie valoare
            for (String key : configs.keySet()) {
                properties.setProperty(key, configs.get(key));
            }
            properties.store(outputStream, null);


        } catch (IOException exception) {
            Log.error("File may not be found " + Constants.CONFIG_PATH + Constants.CONFIG_FILE);
            Log.fatal(GeneralUtils.stackTraceConvert(exception.getStackTrace()));


        }
    }
}
