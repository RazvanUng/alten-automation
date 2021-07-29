package utils;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

    public static String URL;
    public static String ENV;
    public static String BROWSER;
    public static boolean WEB_DRIVER_MANAGER;


    public static void readConfigFile() {
        try
                (InputStream inputStream = new FileInputStream(Constants.CONFIG_PATH+Constants.CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String port = properties.getProperty("URL_PORT", "80");
            String hostname = properties.getProperty("ULR_HOSTNAME", "localhost");
            String proto = properties.getProperty("URL_PROTOCOL", "http");
            URL = proto + "://" + hostname + ":" + port + "/";
            ENV = properties.getProperty("CURRENT_ENV");
            BROWSER = properties.getProperty("RUN_BROWSER");
            WEB_DRIVER_MANAGER = Boolean.parseBoolean(properties.getProperty("WEB_DRIVER_MANAGER"));

            Log.info(URL);

        } catch (IOException exception) {
            // exception.printStackTrace();
            Log.error("File may not be found "+Constants.CONFIG_PATH+Constants.CONFIG_FILE);
            Log.fatal(GeneralUtils.stackTraceConvert(exception.getStackTrace()));


        }
    }

    public static void writeConfigFile(Map<String, String> configs) {
        try
                (OutputStream outputStream = new FileOutputStream(Constants.CONFIG_PATH+Constants.CONFIG_FILE)) {
            Properties properties = new Properties();
            //pentru fiecare cheie valoare
            for (String key : configs.keySet()) {
                properties.setProperty(key, configs.get(key));
            }
            properties.store(outputStream, null);


        } catch (IOException exception) {
            Log.error("File may not be found "+Constants.CONFIG_PATH+Constants.CONFIG_FILE);
            Log.fatal(GeneralUtils.stackTraceConvert(exception.getStackTrace()));


        }
    }
}
