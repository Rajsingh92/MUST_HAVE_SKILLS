/**
Print first letter of every word in the string 
Given a string S, the task is to create a string with the first letter of every word in the string.

Example 1:

Input: 
S = "geeks for geeks"
Output: gfg
 */

 
class Solution {
    String firstAlphabet(String S) {

        boolean isFirst = true;
        String ans = "";

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch != ' ' && isFirst == true) {
                ans += ch;
                isFirst = false;
            } else if (ch == ' ') {
                isFirst = true;
            }
        }

        return ans;
    }
};