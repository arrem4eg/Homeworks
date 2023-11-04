package homework9;

import java.util.Arrays;

public class Task3 {
    public static String removeString(String str, String[] removeChars) {

        String temp = str;

        for (int i = 0; i < removeChars.length; i++) {
            temp = temp.replaceAll(removeChars[i], "");
        }

        return temp;
    }
}
