import java.util.*;

class Infix {

    public static int evaluateInfix(String exp) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int opval = operation(val1, val2, op);
                    operands.push(opval);
                }

                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int opval = operation(val1, val2, op);
                    operands.push(opval);
                }

                if (operators.size() > 0) {
                    operators.pop();
                }
            }
        }

        while (operators.size() > 0) {
            int val2 = operands.pop();
            int val1 = operands.pop();
            char op = operators.pop();

            int opval = operation(val1, val2, op);
            operands.push(opval);
        }

        int val = operands.pop();
        return val;
    }

    public static String infixToPostfix(String exp) {
        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                postfix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    char op = operators.pop();
                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1 + postval2 + op);
                }

                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    char op = operators.pop();
                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1 + postval2 + op);
                }

                if (operators.size() > 0) {
                    operators.pop();
                }
            }
        }

        while (operators.size() > 0) {
            char op = operators.pop();
            String postval2 = postfix.pop();
            String postval1 = postfix.pop();
            postfix.push(postval1 + postval2 + op);
        }

        return postfix.peek();
    }

    public static String infixToPrefix(String exp) {
        Stack<String> prefix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    char op = operators.pop();
                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(op + preval1 + preval2);
                }

                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    char op = operators.pop();
                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(op + preval1 + preval2);
                }

                if (operators.size() > 0) {
                    operators.pop();
                }
            }
        }

        while (operators.size() > 0) {
            char op = operators.pop();
            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            prefix.push(op + preval1 + preval2);
        }

        return prefix.peek();
    }

    public static int precedence(char op) {
        if (op == '+') {
            return 1;
        } else if (op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int val1, int val2, char op) {
        if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else if (op == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

}


class postfix {
    public static int evaluatePostFix(String S) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int a = st.pop();
                int b = st.pop();

                if (ch == '+') st.push(b + a);
                if (ch == '-') st.push(b - a);
                if (ch == '*') st.push(b * a);
                if (ch == '/') st.push(b / a);
            } else {
                st.push(ch - '0');
            }
        }

        return st.peek();
    }

    public static String postfixToInfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op2 + ch + op1 + ")";
                stack.push(temp);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }

    public static String postfixToPrefix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = ch + op2 + op1;
                stack.push(temp);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }
}



class Prefix {

    public static int evaluatePrefix(String exp) {
        Stack<Integer> st = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                int a = st.pop();
                int b = st.pop();
                st.push(calcuate(a, b, ch));
            } else {
                st.push(ch - '0');
            }
        }

        return st.pop();
    }

    public static String prefixToInfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + ch + op2 + ")";
                stack.push(temp);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }

    public static String prefixToPostfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = op1 + op2 + ch;
                stack.push(temp);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }

    public static int calcuate(int a, int b, char ch) {
        if (ch == '+')
            return a + b;
        else if (ch == '-')
            return a - b;
        else if (ch == '*')
            return a * b;
        else
            return a / b;
    }
}

