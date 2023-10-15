package homework12;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Task2 {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5);

        Set<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 6, 7, 8, 9, 10);

        Set<Integer> set3 = new HashSet<>();
        set3.addAll(set1);
        set3.addAll(set2);

        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("set1 + set2: " + set3);
    }
}
