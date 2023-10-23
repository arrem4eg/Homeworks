package homework2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        int number;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        number = scanner.nextInt();


        String result = (number % 2 == 0) ? "введене число є парним" : "введене число не є парним";
        System.out.println("###########################");
        System.out.println(result);
    }
}
