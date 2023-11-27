package homework19.tests;

import homework19.utils.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AutomationexerciseTest extends BaseTest {

    @Test
    public void checkStatusMessage() {
        String status = openMainPage()
                .pressContactUsButton()
                .fillFields()
                .uploadFile()
                .pressSubmitButton()
                .getStatusMessage();

        assertTrue(status.contains("Success! Your details"));
    }
}
