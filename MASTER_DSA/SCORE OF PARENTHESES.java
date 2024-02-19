/**
Score of Parentheses

Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "(()(()))"
Output: 6
 */
import java.util.*;

class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                if (st.peek() >= 0 && S.charAt(st.peek()) == '(') {
                    st.pop();
                    st.push(-1);
                } else {
                    int sum = 0;
                    while (st.size() > 0 && st.peek() < 0) {
                        sum += st.pop();
                    }
                    st.pop();
                    st.push(2 * sum);
                }
            }
        }

        int ans = 0;
        while (st.size() > 0) {
            ans += st.pop();
        }
        return -ans;
    }

    // O(1)
    public int scoreOfParentheses2(String S) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                depth++;
            } else {
                depth--;
            }

            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                score += Math.pow(2, depth);
            }
        }

        return score;
    }
}