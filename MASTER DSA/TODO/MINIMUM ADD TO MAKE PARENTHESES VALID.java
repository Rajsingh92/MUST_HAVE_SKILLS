/**
Minimum Add to Make Parentheses Valid |  Medium | Facebook |
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
 */

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        
        for(int i= 0 ; i<S.length();i++){
            char ch = S.charAt(i);
            if(st.size()!=0 && st.peek() == '(' && ch == ')'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        
        return st.size();
    }

    public int minAddToMakeValid2(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}