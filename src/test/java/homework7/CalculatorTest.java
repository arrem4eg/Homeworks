package homework7;

import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void additionInt() {
        System.out.println("4 + 6 = " + calculator.add(4, 6));
    }

    @Test
    public void additionDouble() {
        System.out.println("4.4 + 7 = " + calculator.add(4.4, 7));
    }

    @Test
    public void subtractionInt() {
        System.out.println("3 - 5 = " + calculator.subtract(3, 5));
    }

    @Test
    public void subtractionDouble() {
        System.out.println("7.4 - 5.9 = " + calculator.subtract(7.4, 5.9));
    }

    @Test
    public void multiplicationInt() {
        System.out.println("9 * 5 = " + calculator.multiply(9, 5));
    }

    @Test
    public void multiplicationDouble() {
        System.out.println("3.2 * 8.1 = " + calculator.multiply(3.2, 8.1));
    }

    @Test
    public void divisionInt() {
        System.out.println("7 / 2 = " + calculator.divide(7, 2));
    }

    @Test
    public void divisionDouble() {
        System.out.println("14.7 / 7.1 = " + calculator.divide(14.7, 7.1));
    }
}
