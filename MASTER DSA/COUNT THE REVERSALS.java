/**
Count the Reversals 

Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the 
minimum number of reversals required to convert the string into a balanced expression.
A reversal means changing '{' to '}' or vice-versa.

Example 1:

Input:
S = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.
â€‹Example 2:

Input: 
S = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.
 */

class Sol {
    int countRev(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                left++;
            } else {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }

        return (int) (Math.ceil((left + 1) / 2) + Math.ceil((right + 1) / 2));
    }
}