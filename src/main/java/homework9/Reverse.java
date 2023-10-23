package homework9;
public class Reverse {

    public static String reverseString(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

}