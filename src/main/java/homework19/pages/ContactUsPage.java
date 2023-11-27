package homework19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ContactUsPage extends BasePage {

    @FindBy(css = "[name='name']")
    WebElement nameField;

    @FindBy(css = "[name='email']")
    WebElement emailField;

    @FindBy(css = "[name='subject']")
    WebElement subjectField;

    @FindBy(css = "[name='message']")
    WebElement messageField;

    @FindBy(css = "[name='upload_file']")
    WebElement uploadField;

    @FindBy(css = "[name='submit']")
    WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    WebElement statusMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage fillFields() {
        setText(nameField, getData("name"));
        setText(emailField, getData("email"));
        setText(subjectField, getData("subject"));
        setText(messageField, getData("message"));
        return this;
    }

    public ContactUsPage uploadFile() {
        setText(uploadField, new File(getData("uploadFile")).getAbsolutePath());
        return this;
    }

    public ContactUsPage pressSubmitButton() {
        clickButton(submitButton);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    public String getStatusMessage() {
        return statusMessage.getText();
    }

}
