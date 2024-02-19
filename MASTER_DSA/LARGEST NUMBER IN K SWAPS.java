/**
Largest number in K swaps 
Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing 
swap operations on the digits of str at most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
 */

class Solution {

    static String max;
    public static String findMaximumNum(String str, int k) {
        max = str;
        findMaximumNum(str.toCharArray(), k);
        return max;
    }

    static void findMaximumNum(char[] str, int k) {
        if (k == 0)
            return;

        
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i] < str[j]) {
                    
                    char t = str[i];
                    str[i] = str[j];
                    str[j] = t;


                    if (String.valueOf(str).compareTo(max) > 0)
                        max = String.valueOf(str);

                    findMaximumNum(str, k - 1);

                    char c = str[i];
                    str[i] = str[j];
                    str[j] = c;
                }
            }
        }
    }
}