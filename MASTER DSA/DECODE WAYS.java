/**
Decode Ways |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the 
mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 */


class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return numDecodings(s, s.length(), dp);

    }

    public int numDecodings(String str, int n, int[] dp) {

        if (n == 0 || n == 1)
            return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        int res = 0;
        if (str.charAt(n - 1) > '0') {
            res += numDecodings(str, n - 1, dp);
        }

        if (str.charAt(n - 2) == '1') { // 10 to 19
            res += numDecodings(str, n - 2, dp);
        } else if (str.charAt(n - 2) == '2' && str.charAt(n - 1) < '7') { // 22 to 26
            res += numDecodings(str, n - 2, dp);
        }

        dp[n] = res;
        return dp[n];
    }

    public int numDecodings_DP(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));

            if (first >= 1 && first <= 9)
                dp[i] = dp[i] + dp[i - 1];

            if (second >= 10 && second <= 26)
                dp[i] = dp[i] + dp[i - 2];
        }

        return dp[dp.length - 1];
    }

    public int numDecodings_Opti(String s) {
        int a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            int count = 0;
            char ch1 = s.charAt(idx);
            if (ch1 != '0') {

                count += a;

                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num <= 26)
                        count += b;
                }
            }
            b = a;
            a = count;
        }

        return a;
    }
}












/**
public class Q639 {
    // Decode Ways II |  Hard | Facebook |
    // 639
    long numDecodings_memo(String s, int idx, long[] dp) {

        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];
        if (s.charAt(idx) == '0') {
            return 0;
        }

        long count = 0;
        char ch1 = s.charAt(idx);

        if (s.charAt(idx) == '*') {
            count = (count + 9 * numDecodings_memo(s, idx + 1, dp)) % mod;
            if (idx < s.length() - 1) {
                char ch2 = s.charAt(idx + 1);
                if (ch2 == '*')
                    count = (count + 15 * b) % mod;
                else if (ch2 >= '0' && ch2 <= '6')
                    count = (count + 2 * b) % mod;
                else if (ch2 > '6')
                    count = (count + b) % mod;

            }
        } else {
            count = (count + numDecodings_memo(s, idx + 1, dp)) % mod;
            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) != '*') {
                    char ch2 = s.charAt(idx + 1);
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num <= 26)
                        count = (count + b) % mod;
                } else {
                    if (s.charAt(idx) == '1')
                        count = (count + 9 * b) % mod;
                    else if (s.charAt(idx) == '2')
                        count = (count + 6 * b) % mod;
                }
            }
        }

        return dp[idx] = count;
    }

    long numDecodings_dp(String s, int IDX, long[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
                continue;
            }

            long count = 0;
            char ch1 = s.charAt(idx);

            if (s.charAt(idx) == '*') {
                count = (count + 9 * a) % mod;
                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    if (ch2 == '*')
                        count = (count + 15 * b) % mod;
                    else if (ch2 >= '0' && ch2 <= '6')
                        count = (count + 2 * b) % mod;
                    else if (ch2 > '6')
                        count = (count + b) % mod;

                }
            } else {
                count = (count + a) % mod;
                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        char ch2 = s.charAt(idx + 1);
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if (num <= 26)
                            count = (count + b) % mod;
                    } else {
                        if (s.charAt(idx) == '1')
                            count = (count + 9 * b) % mod;
                        else if (s.charAt(idx) == '2')
                            count = (count + 6 * b) % mod;
                    }
                }
            }

            dp[idx] = count;
        }

        return (int) dp[IDX];
    }

    long numDecodings_opti(String s) {
        long a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            long count = 0;
            char ch1 = s.charAt(idx);
            if (ch1 == '0') {
                count = 0;
            } else if (ch1 == '*') {
                count = (count + 9 * a) % mod;
                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    if (ch2 == '*')
                        count = (count + 15 * b) % mod;
                    else if (ch2 >= '0' && ch2 <= '6')
                        count = (count + 2 * b) % mod;
                    else if (ch2 > '6')
                        count = (count + b) % mod;

                }
            } else {
                count = (count + a) % mod;
                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        char ch2 = s.charAt(idx + 1);
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if (num <= 26)
                            count = (count + b) % mod;
                    } else {
                        if (s.charAt(idx) == '1')
                            count = (count + 9 * b) % mod;
                        else if (s.charAt(idx) == '2')
                            count = (count + 6 * b) % mod;
                    }
                }
            }

            b = a;
            a = count;
        }

        return (int) a;
    }

    int numDecodings_II(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        long ans = numDecodings_memo(s, 0, dp);
        return (int) ans;
    }

    static int m = (int) 1e9 + 7;

    public static long decodeWaysII(String s,int idx,long[] dp){
		if(idx==s.length()) return dp[idx]=1;

		if(dp[idx]!=0) return dp[idx];
		
        long count=0;
        int n=s.length();
		char ch=s.charAt(idx);
		if(ch=='*'){   // *(char) , **
           count = (count +  9*decodeWaysII(s,idx+1,dp)) % m; // value of '*' vary from 1-9
           
           if(idx + 1 < n && s.charAt(idx+1) >= '1' && s.charAt(idx+1) <= '6')  // *(char) : char vary from 1-6 it make only 2 calls of two length 
              count = (count +  2 * decodeWaysII(s,idx+2,dp)) % m; // value of '*' vary from 1-2

           if(idx + 1 < n && s.charAt(idx+1) >= '7' && s.charAt(idx+1) <= '9')  // *(char) : char vary from 7-9 it make only 2 calls of two length
               count = (count +   decodeWaysII(s,idx+2,dp)) % m; // value of '*' vary from 1-1     
            
           if(idx + 1 < n && s.charAt(idx+1) >= '*')  // ** : star vary from 1-9 it make only 15 calls of two length
               count = (count +  15*decodeWaysII(s,idx+2,dp)) % m;      
        }else if(ch!='0'){
            count = (count +  9*decodeWaysII(s,idx+1,dp)) % m; 

            if(idx + 1 < n){
                if(s.charAt(idx+1) == '*'){
                    if(s.charAt(idx) == '1')
                       count = (count +   9*decodeWaysII(s,idx+2,dp)) % m;
                    else if(s.charAt(idx) == '2')
                       count = (count +   6*decodeWaysII(s,idx+2,dp)) % m;

                }else{
                    int digit = (ch - '0') * 10 + (s.charAt(idx+1) - '0');
                    if(digit >= 10 && digit <= 26)
                      count = (count +   decodeWaysII(s,idx+2,dp)) % m; 
                }
            }


        }
}

 */

