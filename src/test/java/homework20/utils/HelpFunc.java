package homework20.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static homework20.utils.BaseTest.driver;

public class HelpFunc {

    public static File file;

    public static File getFile(String downloadFolder, String fileName) {
        return new File(downloadFolder + fileName).getAbsoluteFile();
    }

    public static boolean fileIsExist(String downloadFolder, String fileName) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(100));
        file = getFile(downloadFolder, fileName);
        fluentWait.until(x -> file.exists());
        return file.exists();
    }

    public static String fileIsEmpty(String downloadFolder, String fileName) {
        return String.valueOf(getFile(downloadFolder, fileName).length());
    }

    public static String getExtension(String downloadFolder, String fileName) {
        String[] string = getFile(downloadFolder, fileName).getName().split("\\.");
        return string[string.length - 1];
    }

    public static List<String> readFile(String downloadFolder, String fileName) {
        try {
            return Files.readAllLines(Paths.get(downloadFolder + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCsvHeaders(String downloadFolder, String fileName) {
        return readFile(downloadFolder, fileName).get(0);
    }

    public static String getFirstRow(String downloadFolder, String fileName) {
        return readFile(downloadFolder, fileName).get(1);
    }
}
