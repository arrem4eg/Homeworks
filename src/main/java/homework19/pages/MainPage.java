package homework19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@href='/contact_us']")
    WebElement contactUsButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage pressContactUsButton() {
        clickButton(contactUsButton);
        return new ContactUsPage(driver);
    }
}
