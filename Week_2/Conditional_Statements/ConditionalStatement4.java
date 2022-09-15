package Week_2.Conditional_Statements;

import java.util.Scanner;

public class ConditionalStatement4 {
    
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int total = 0;
            int gradeCounter = 1;

            while (gradeCounter <= 10) {
                System.out.print("Enter grade: ");
                int grade = input.nextInt();
                total = total + grade;
                gradeCounter = gradeCounter + 1;
            }
        }
    }
}
