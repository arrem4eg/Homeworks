package homework9;
import java.util.Arrays;

public class Task3 {
    public static String removeString(String str1, String[] removeChars) {

        int len = removeChars.length;
        String temp = str1;

        for (int i = 0; i < len; i++) {
            temp = temp.replaceAll(removeChars[i], "");
        }

        return temp;
    }
}
