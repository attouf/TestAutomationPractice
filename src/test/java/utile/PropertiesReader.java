package utile;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static String loadProp(String propertyName) throws Exception {

        InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(propertyName);
    }
}


