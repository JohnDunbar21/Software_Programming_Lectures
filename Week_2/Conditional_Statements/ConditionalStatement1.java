package Week_2.Conditional_Statements;

public class ConditionalStatement1 {

    public static void main(String[] args) {
        int number1 = 3;
        int number2 = 7;

        if (number1 == number2) {
            System.out.printf("%d == %d%n", number1, number2);
        }

        if (number1 != number2) {
            System.out.printf("%d != %d%n", number1, number2);
        }

        if (number1 < number2) {
            System.out.printf("%d < %d%n", number1, number2);
        }

        if (number1 > number2) {
            System.out.printf("%d > %d%n", number1, number2);
        }
    }   
}