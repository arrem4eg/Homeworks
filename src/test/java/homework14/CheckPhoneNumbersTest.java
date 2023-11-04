package homework14;

import homework9.Task4;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckPhoneNumbersTest extends Template {

    @DataProvider(name = "validNumbers")
    public Object[][] validNumbers() {
        return new Object[][]{
                {"+38(013)4520397"},
                {"+38(050)1234567"}
        };
    }

    @Test(groups = "Check PhoneNumbers", dataProvider = "validNumbers")
    public void isValidPhoneNumbers(String phoneNumber) {
        assertTrue(Task4.checkPhoneNumber(phoneNumber));
    }


    @DataProvider(name = "invalidNumbers")
    public Object[][] invalidNumbers() {
        return new Object[][]{
                {"+380501234567"},
                {"(050)1234567"},
                {"+38(06)4567890"},
        };
    }

    @Test(groups = "Check PhoneNumbers", dataProvider = "invalidNumbers")
    public void isInvalidPhoneNumbers(String phoneNumber) {
        assertFalse(Task4.checkPhoneNumber(phoneNumber));
    }
}
