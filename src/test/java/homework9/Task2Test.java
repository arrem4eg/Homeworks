package homework9;

import org.testng.annotations.Test;

public class Task2Test {

    @Test
    public void removeString() {

        String string1 = "This is the test string";
        String string2 = "st";
        System.out.println("string1: " + string1);
        System.out.println("string2: " + string2);
        System.out.println("result: " + Task2.rmString(string1, string2));


    }
}
