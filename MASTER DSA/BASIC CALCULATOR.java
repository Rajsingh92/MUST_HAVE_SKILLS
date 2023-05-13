
import java.io.*;
import java.util.*;

// Basic Calculator |  Hard | Adobe, Amazon, Facebook, Google, Microsoft |
public class Main {

    public static int calculate(String s) {

        int sum = 0;
        int sign = 1;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val = val * sign;
                sign = 1;
                sum += val;
            } else if (ch == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = +1;
            } else if (ch == ')') {
                sum *= st.pop();
                sum += st.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);

    }
}

// Basic Calculator II | Medium | Amazon, Apple, Facebook, Google, Microsoft |
public class Main {
    public static int calculate(String s) {

        Stack<Integer> st = new Stack<>();

        int val = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                val = val * 10 + (ch - '0');
            }
            if (i + 1 == s.length() || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (sign == '+') {
                    st.push(val);
                } else if (sign == '-') {
                    st.push(-val);
                } else if (sign == '*') {
                    st.push(st.pop() * val);
                } else if (sign == '/') {
                    st.push(st.pop() / val);
                }
                val = 0;
                sign = ch;
            }
        }

        int sum = 0;
        while (st.size() > 0) {
            sum += st.pop();
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);

    }
}

// Basic Calculator III | Hard | Amazon, Facebook, Google, Microsoft |
public class Main {
    static class Pair {
        Stack<Integer> stP;
        char sign;

        Pair(Stack<Integer> st, char s) {
            stP = st;
            sign = s;
        }
    }

    public static int calculate(String s) {
        Stack<Pair> stP = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                cal(st, sign, val);
            } else

            if (ch == '(') {
                stP.push(new Pair(st, sign));
                sign = '+';
                st = new Stack<>();
            } else if (ch == ')') {
                Pair p = stP.pop();
                int sum = 0;
                while (st.size() > 0)
                    sum += st.pop();
                st = p.stP;
                sign = p.sign;
                cal(st, sign, sum);
            } else if (ch != ' ') {
                sign = ch;
            }
        }

        int sum = 0;
        while (st.size() > 0)
            sum += st.pop();

        return sum;
    }

    public static void cal(Stack<Integer> st, char sign, int val) {
        if (sign == '+') {
            st.push(val);
        } else if (sign == '-') {
            st.push(-val);
        } else if (sign == '*') {
            int a = st.pop();
            int ans = a * val;
            st.push(ans);
        } else if (sign == '/') {
            int a = st.pop();
            int ans = a / val;
            st.push(ans);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);

    }
}
