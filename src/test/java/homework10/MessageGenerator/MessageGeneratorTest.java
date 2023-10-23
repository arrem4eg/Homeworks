package homework10.MessageGenerator;

import org.testng.annotations.Test;

public class MessageGeneratorTest {

    @Test
    public void getInfoMessage() {
        String info1 = MessageGenerator.infoMessage("Android", "version 13.0");
        String info2 = MessageGenerator.infoMessage("MS Windows", "11.0");
        System.out.println(info1);
        System.out.println(info2);

        System.out.println("############################################\n");
    }

    @Test
    public void getErrorMessage() {
        String error1 = MessageGenerator.errorMessage("example.com", 404, "page not found");
        String error2 = MessageGenerator.errorMessage("i.ua", 500, "Internal Server Error");
        System.out.println(error1);
        System.out.println(error2);

        System.out.println("############################################\n");
    }

    @Test
    public void getHardDiskMessage() {
        String hardDisk1 = MessageGenerator.diskMessage("c:\\", 125.5);
        String hardDisk2 = MessageGenerator.diskMessage("d:\\", 400.35);
        System.out.println(hardDisk1);
        System.out.println(hardDisk2);

        System.out.println("############################################\n");

    }

    @Test
    public void getListOfBestBooksMessage() {
        String books = MessageGenerator.getListOfBooksMessage("'Head First Java'",
                                                                "'Java: A Beginner’s Guide'",
                                                                "'Java for Dummies'",
                                                                "'Effective Java'",
                                                                "'Head First Design Patterns'");
        System.out.println(books);
    }

}
