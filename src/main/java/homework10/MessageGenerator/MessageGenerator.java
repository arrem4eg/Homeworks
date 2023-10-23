package homework10.MessageGenerator;

public class MessageGenerator {
    public static String infoMessage(String str1, String str2) {
        return String.format("This program runs on %s %s", str1, str2);
    }

    public static String errorMessage(String str1, int num1, String str2) {
        return String.format("%s has error %d %s", str1, num1, str2);
    }

    public static String diskMessage(String srt1, double num1) {
        return String.format("%.2f GB used space on %s drive", num1, srt1);
    }

    public static String getListOfBooksMessage(String... str1) {
        return String.format("List of Best Java Books: %s.", arrayToString(str1));
    }


    public static String arrayToString(Object[] o) {
        int iMax = o.length;
        StringBuilder tempString = new StringBuilder();

        for (int i = 0; i < iMax; i++) {
            tempString.append(o[i]);
            if (i != iMax - 1)
                tempString.append(", ");
        }
        return tempString.toString();
    }
}
