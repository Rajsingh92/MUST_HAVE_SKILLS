
/**
Check If Word Is Valid After Substitutions
Given a string s, determine if it is valid.
A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the 
following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.

 

Example 1:

Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.
 */

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'c') {
                if (st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a') {

                } else {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }

        return st.size() == 0;
    }
}
