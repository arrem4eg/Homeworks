package homework14;

import homework9.Task3;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveCharsTest extends Template {

    @Test(groups = "Remove Chars")
    public void testRemoveCharsWithValidInput() {
        String str = "abcd4efabc123deabcdaaa";
        String[] removeChars = {"a", "d", "3"};
        assertEquals(Task3.removeString(str, removeChars), "bc4efbc12ebc");
    }

    @Test(groups = "Remove Chars")
    public void testRemoveCharsWithNoMatchingCharacters() {
        String str = "abcdef12345";
        String[] removeChars = {"7", "x"};
        assertEquals(Task3.removeString(str, removeChars), "abcdef12345");
    }
}
