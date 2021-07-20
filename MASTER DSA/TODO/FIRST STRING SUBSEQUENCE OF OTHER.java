/**
Check for subsequence 

Given two strings A and B, find if A is a subsequence of B.

Example 1:

Input:
A = AXY 
B = YADXCP
Output: 0 
Explanation: A is not a subsequence of B
as 'Y' appears before 'A'.
 */

public class Solution {
    public static boolean isSubSequence(String str1, String str2, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);
        else
            return isSubSequence(str1, str2, m, n - 1);
    }

    public static boolean isSubSequence2(String str1, String str2, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        int i = 0,j = 0;
        while(j<n){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i == m;
    }
}