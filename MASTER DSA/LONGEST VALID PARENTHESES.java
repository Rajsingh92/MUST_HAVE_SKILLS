/**
Longest Valid Parentheses |  Hard | Amazon |

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
 */

import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max_ = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.peek() != -1 && ch == ')' && s.charAt(st.peek()) == '(') {
                st.pop();
                int len = i - st.peek();
                if (max_ < len) {
                    max_ = len;
                }
            } else {
                st.push(i);
            }
        }

        return max_;
    }

    // dp approach
}