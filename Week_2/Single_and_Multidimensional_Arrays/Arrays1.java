package Week_2.Single_and_Multidimensional_Arrays;

public class Arrays1 {
    
    public static void main(String[] args) {
        // declare a new integer array and initialise it to default values of zero with length 10
        int[] array = new int[10];

        System.out.printf("%s%8s%n", "Index", "Value");

        // output each element in the array
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5d%8d%n", i, array[i]);
        }
    }
}
