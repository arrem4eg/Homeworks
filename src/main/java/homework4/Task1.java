package homework4;

public class Task1 {
    public static void main(String[] args) {

        // 1 + 2 + 3 +...+ n = n * (n+1)/2
        // The sum of the  array elements should be  n * (n+1)/2

        int sumArray = 0;
        int[] array = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int n = array.length + 1;       // the number of the array elements + 1 (missing element)

        for (int i : array) {
            sumArray += i;              //The sum of all the array elements
        }


        int missingNumber = (n * (n + 1) / 2 - sumArray);
        System.out.println("The missing number is: " + missingNumber);
    }
}
