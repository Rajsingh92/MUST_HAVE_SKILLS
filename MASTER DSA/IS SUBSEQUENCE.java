/**
Is Subsequence |  Medium | Facebook, Google |

Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int i = 0;
        int j = 0;

        while (j < t.length()) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(j);
            if (ch1 == ch2) {
                i++;
            }

            j++;

            if (i >= s.length())
                return true;
        }

        return false;
    }
}