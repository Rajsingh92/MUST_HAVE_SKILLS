import java.util.*;

public class Main {
    public static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char ans[] = new char[s.length()];
        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                int from = st.pop();
                reverse(ans, from, last - 1);
            } else if (c == '(') {
                st.push(last);
            } else {
                ans[last++] = c;
            }
        }

        return new String(ans, 0, last);
    }

    private static void reverse(char ch[], int i, int j) {
        while (i < j) {
            char t = ch[i];
            ch[i] = ch[j];
            ch[j] = t;
            i++;
            j--;
        }
    }
}
