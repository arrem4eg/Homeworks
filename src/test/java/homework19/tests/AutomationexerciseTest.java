package homework19.tests;

import homework19.pages.ContactUsPage;
import homework19.utils.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AutomationexerciseTest extends BaseTest {

    @Test
    public void checkStatusMessage() {

        String status = openMainPage()
                .pressContactUsButton()
                .fillFields(props.getData("name"), props.getData("email"), props.getData("subject"), props.getData("message"))
                .uploadFile(props.getData("uploadFile"))
                .pressSubmitButton()
                .getStatusMessage();

        assertTrue(status.contains("Success! Your details"));
    }
}
