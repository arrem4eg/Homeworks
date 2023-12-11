package homework20.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropTest {
    private final Properties properties;

    public PropTest() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/homework20.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getData(String element) {
        return properties == null ? null : properties.getProperty(element);
    }
}
