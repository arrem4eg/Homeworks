package homework4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        String validPassword = "P@$$word123";
        String password;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            if (!validPassword.equals(password))
                System.out.println("Error. Enter the correct password.");
        } while (!validPassword.equals(password));

        System.out.println("The password is correct. ");

    }
}
