package homework3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        double a, b, c, D;

        Scanner scanner = new Scanner(System.in);
        System.out.println("програмa на Java для розв’язування квадратних рівнянь ax²+bx+c=0");
        System.out.print("Enter the value 'a': ");
        a = scanner.nextDouble();
        System.out.print("Enter the value 'b': ");
        b = scanner.nextDouble();
        System.out.print("Enter the value 'c': ");
        c = scanner.nextDouble();

        D = b * b - 4 * a * c;

        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("корені рівняння дорівнюють: x1 = " + x1 + ", x2 = " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println("корінь рівняння дорівнює: x = " + x);

        } else {
            System.out.println("дане рівняння не має коріння");
        }


    }
}
