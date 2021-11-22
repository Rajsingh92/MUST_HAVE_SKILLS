/**
Backspace String Compare

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
 */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        String str1 = getRes(S);
        String str2 = getRes(T);

        return str1.equals(str2);
    }

    public String getRes(String str) {
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        int count = 0;

        while (i >= 0) {
            char ch = str.charAt(i);
            if (ch == '#') {
                count++;
            } else if (count != 0) {
                count--;
            } else {
                sb.append(ch);
            }
            i--;
        }

        return sb.toString();
    }
}