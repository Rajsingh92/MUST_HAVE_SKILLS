/**
Maximum difference of zeros and ones in binary string 

Given a binary string of 0s and 1s. The task is to find the maximum difference of the number of 0s and the number of 1s 
(number of 0s – number of 1s) in the substrings of a string.

Note: In the case of all 1s, the answer will be -1.

Example 1:

Input : S = "11000010001" 
Output : 6 
Explanatio: From index 2 to index 9, 
there are 7 0s and 1 1s, so number 
of 0s - number of 1s is 6. 
 */

class Solution {
    int maxSubstring(String S) {
        int csum = 0;
        int bsum = 0;

        for (int i = 0; i < S.length(); i++) {
            int val = S.charAt(i) == '1' ? -1 : 1;

            if (csum > 0) {
                csum += val;
            } else {
                csum = val;
            }

            bsum = Math.max(bsum, csum);
        }

        if (bsum == 0) {
            bsum = -1;
        }

        return bsum;
    }
}