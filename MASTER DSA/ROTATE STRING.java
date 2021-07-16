/**
Rotate String

We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. 
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if 
A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
 */

class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public boolean rotateString2(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals("") && B.equals("")) {
            return true;
        }

        int i = A.length() - 1;
        String ss = A;

        while (i >= 0) {
            ss = ss.substring(1) + ss.charAt(0);
            if (ss.equals(B)) {
                return true;
            }
            i--;
        }

        return false;
    }
}