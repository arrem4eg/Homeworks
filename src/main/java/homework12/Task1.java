package homework12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            numbers.add(i);
        System.out.println("numbers: " + numbers);

        numbers.removeIf(x -> x % 2 != 0);
        System.out.println("even numbers: " + numbers);
    }
}
