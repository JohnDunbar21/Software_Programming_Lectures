package Week_2.Single_and_Multidimensional_Arrays;

public class Arrays4 {

    // multiply each element of an array by 2
    public static void modifyArray(int[] array2) {
        for (int i = 0; i <array2.length; i++) {
            array2[i] *= 2;
        }
    }

    // multiply the element by 2
    public static void modifyElement(int element) {
        element *= 2;
        System.out.printf("Value of element in modifyElement: %d%n", element);
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.printf("Effects of passing reference to entire array:%n"+"The values of the original array are:%n");

        // output original array elements
        for (int value : array) {
            System.out.printf("     %d", value);
        }

        modifyArray(array);
        System.out.printf("%n%nThe values of the modified array are:%n");

        // output modified array elements
        for (int value: array) {
            System.out.printf("     %d", value);
        }

        System.out.printf("%n%nEffects of passing array element value:%n"+"array[3] before modifyElement: %d%n", array[3]);

        modifyElement(array[3]);
        System.out.printf("array[3] after modifyElement: %d%n", array[3]);

    }
}