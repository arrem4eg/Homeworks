package homework9;

import org.testng.annotations.Test;

public class Task4Test {

    @Test
    public void isValidNumber() {

        String[] phoneNumber = {"+38(013)4520397",
                "+380501234567",
                "+38(050)1234567",
                "(050)1234567",
                "0(501)234567",
                "+38)050(1234567",
                "+38(050)123-45-67",
                "050ххх4567",
                "(0)501234567",
                "+38(06)4567890"};
        for (String i : phoneNumber)
            if (Task4.checkPhoneNumber(i)) {
                System.out.println("Bведений номер телефона " + i + " є у форматі +38(0хх)ххххххх");
            }
    }
}
