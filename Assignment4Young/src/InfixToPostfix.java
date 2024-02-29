import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infixExpression.toCharArray()) {
            if (isOperand(c)) {
                postfixExpression.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }
                stack.pop(); // pop the '('
            } else {
                // c is an operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }

        return postfixExpression.toString();
    }

    private static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; // Invalid operator
        }
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        String postfixExpression = infixToPostfix(infixExpression);

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}

