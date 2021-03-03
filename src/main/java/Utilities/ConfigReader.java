package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    private static ConfigReader configReader = new ConfigReader();

    private ConfigReader(){

        File file = new File("src//test//resources//Config.properties");

        try {

            FileInputStream fis = new FileInputStream(file);

            prop = new Properties();

            prop.load(fis);

        } catch (Exception e){

            e.printStackTrace();
        }

    }

    public static ConfigReader getConfigReader(){

        return configReader;
    }

    public String getURI(){

        return prop.getProperty("URI");
    }

    public String getUserName(){

        return prop.getProperty("userName");
    }

    public String getPassword(){

        return prop.getProperty("password");
    }
}
