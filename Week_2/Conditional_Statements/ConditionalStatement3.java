package Week_2.Conditional_Statements;

public class ConditionalStatement3 {
    
    public static void main(String[] args) {
        int studentGrade = 76;

        //Below is the conditional operator. It will only wor if the logic can fit onto a single line, but greatly improves efficiency.

        System.out.println(studentGrade >= 60 ? "Passed" : "Failed");
                        // boolean expression -> if true -> if false
    }
}
