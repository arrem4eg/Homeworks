package homework9;
import org.testng.annotations.Test;

public class ReverseTest {

    @Test
    public void checkReverse() {
        String str = "Java, World!";
        System.out.println("Original string: " + str);
        String reverse = Reverse.reverseString(str);
        System.out.println("Reversed string: " + reverse);

    }
}
