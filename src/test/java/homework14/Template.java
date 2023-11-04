package homework14;

import org.testng.annotations.*;

public abstract class Template {

    public static int counter = 1;

    @BeforeTest
    public static void beforeTest() {
        System.out.println("------------ Testing started ----------------");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("------------ Testing finished ----------------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.printf("Test %d started \n", counter);
    }

    @AfterMethod
    public static void afterMethod() {
        System.out.printf("Test %d finished \n", counter++);
    }

    @BeforeGroups(groups = "Reverse")
    public void beforeGroupsTask1() {
        System.out.println("========= Reverse Test=========");
    }

    @BeforeGroups(groups = "Remove String")
    public void beforeGroupsTask2() {
        System.out.println("========= Remove String =========");
    }

    @BeforeGroups(groups = "Remove Chars")
    public void beforeGroupsTask3() {
        System.out.println("========= Remove Chars =========");
    }

    @BeforeGroups(groups = "Check PhoneNumbers")
    public void beforeGroupsTask4() {
        System.out.println("========= Check PhoneNumbers =========");
    }

}
