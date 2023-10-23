package homework2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        int firstNumber;
        int secondNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  the first number: ");
        firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        secondNumber = scanner.nextInt();

        String result = (firstNumber > secondNumber) ? (firstNumber + " > " + secondNumber) : (secondNumber + " > " + firstNumber);
        System.out.println("----------------------");
        System.out.println(result);
    }
}

