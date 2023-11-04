package homework14;

import homework9.Task2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveStringTest extends Template {

    @Test(groups = "Remove String")
    public void testRemoveStringWithMatchingSubstring() {
        String string1 = "This is the test string";
        String string2 = "st";
        assertEquals(Task2.rmString(string1, string2), "This is the te ring");
    }

    @Test(groups = "Remove String")
    public void testRemoveStringWithNonMatchingSubstring() {
        String string1 = "This is the test string";
        String string2 = "abc";
        assertEquals(Task2.rmString(string1, string2), "This is the test string");
    }
}
