package utils;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {


    public static void readConfigFile() {
        try
                (InputStream inputStream = new FileInputStream(Constants.CONFIG_PATH)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String port = properties.getProperty("URL_PORT", "80");
            String hostname = properties.getProperty("ULR_HOSTNAME", "localhost");
            String proto = properties.getProperty("URL_PROTOCOL", "http");
            String URL = proto + "://" + hostname + ":" + port + "/";
            String ENV = properties.getProperty("CURRENT_ENV");

            Log.info(URL);

        } catch (IOException exception) {
            // exception.printStackTrace();
            Log.error("File may not be found");
            Log.fatal(GeneralUtils.stackTraceConvert(exception.getStackTrace()));


        }
    }

    public static void writeConfigFile(Map<String, String> configs) {
        try
                (OutputStream outputStream = new FileOutputStream(Constants.CONFIG_PATH)) {
            Properties properties = new Properties();
            //pentru fiecare cheie valoare
            for (String key : configs.keySet()) {
                properties.setProperty(key, configs.get(key));
            }
            properties.store(outputStream, null);


        } catch (IOException exception) {
            Log.error("File may not be found");
            Log.fatal(GeneralUtils.stackTraceConvert(exception.getStackTrace()));


        }
    }
}
