
/**
Minimum Insertions to Balance a Parentheses String

Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as openning parenthesis and '))' as closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

 

Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to to add one 
more ')' at the end of the string to be "(())))" which is balanced.
 */



public class Solution{
    public int minInsertions(String s) {
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (right % 2 > 0) {
                    right--;
                    res++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return right + res;
    }
}
