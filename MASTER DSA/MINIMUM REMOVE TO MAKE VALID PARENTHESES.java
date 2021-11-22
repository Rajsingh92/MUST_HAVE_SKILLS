/**
Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the 
resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 */



class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(')
                st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty())
                    st.pop();
                else
                    sb.setCharAt(i, '*');
            }
        }

        while (!st.empty())
            sb.setCharAt(st.pop(), '*');

        return sb.toString().replaceAll("\\*", "");
    }
}