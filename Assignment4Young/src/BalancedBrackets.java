// Java program for checking
// balanced brackets
import java.util.*;

public class BalancedBrackets {

    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr)
    {
        Stack<Character> stack = new Stack<Character>();


        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // push the element in the stack
                stack.push(x);
                continue;
            }

            // if current character is not opening bracket, then it must be closing, so stack cannot be empty at this point.

            if (stack.isEmpty()) {
                return false;
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // return stack - empty or not (if empty, then its balanced, if not then it's not balanced)
        return (stack.isEmpty());
    }

    // main testing
    public static void main(String[] args)
    {
        String expr = "([{}])";
        String expr2 = "[{])";

        // function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");

        // function call 2
        if (areBracketsBalanced(expr2))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}