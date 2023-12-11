package homework20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage extends BasePage {

    public DownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void downloadFile(String fileName) {
        clickButton(driver.findElement(By.xpath("//*[@href='download/" + fileName + "']")));
    }
}
