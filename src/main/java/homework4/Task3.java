package homework4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        int number;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("The program displays the sum of the elements. Enter '0' to end the program.");

        do {
            System.out.print("Enter number: ");
            number = scanner.nextInt();
            sum += number;
        } while (number != 0);

        System.out.println("Sum of elements: " + sum);

    }
}
