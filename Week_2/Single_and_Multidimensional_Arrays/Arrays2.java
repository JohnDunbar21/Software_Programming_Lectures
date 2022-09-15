package Week_2.Single_and_Multidimensional_Arrays;

public class Arrays2 {
    
    public static void main(String[] args) {
        // declare a new integer array which has specified the intial value for each element
        int[] array = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};

        System.out.printf("%s%8s%n", "Index", "Value");

        // output each element in the array
        for (int j = 0; j < array.length; j++) {
            System.out.printf("%5d%8d%n", j, array[j]);
        }
    }
}
