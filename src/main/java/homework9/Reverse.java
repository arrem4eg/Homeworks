package homework9;

public class Reverse {

    public static String reverseString(String str) {

        return str.isEmpty() ? str : reverseString(str.substring(1)) + str.charAt(0);
    }

}