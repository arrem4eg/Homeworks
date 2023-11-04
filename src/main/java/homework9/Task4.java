package homework9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static boolean checkPhoneNumber(String number) {

        Pattern pattern = Pattern.compile("^\\+38\\(0\\d{2}\\)\\d{7}$");
        Matcher matcher = pattern.matcher(number);
//        if (matcher.matches()) {
//            System.out.println("Bведений номер телефона " + number + " є у форматі +38(0хх)ххххххх");
//        }
        return matcher.matches();
    }


}
