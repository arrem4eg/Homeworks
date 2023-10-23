package homework9;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Task3Test {

    @Test
    public void rmString() {

        String str1 = "abcd4efabc123deabcdaaa";
        String[] removeChars = {"a", "d", "3"};

        System.out.println("Initial string: " + str1);
        System.out.println("Characters to remove: " + Arrays.toString(removeChars));
        String s = Task3.removeString(str1, removeChars);
        System.out.println("Modified string: " + s);

    }
}
