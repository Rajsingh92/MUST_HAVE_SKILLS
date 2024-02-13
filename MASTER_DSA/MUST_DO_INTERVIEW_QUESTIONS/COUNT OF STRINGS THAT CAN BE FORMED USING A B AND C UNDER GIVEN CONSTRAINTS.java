/**
Count of strings that can be formed using a, b and c under given constraints 

Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one 
‘b’ and two ‘c’s allowed.

Input : n = 3 
Output : 19 

aaa aab aac aba abc aca acb acc baa
bac bca bcc caa cab cac cba cbc cca ccb 
 */



class Solution {

    static int countStr(int n, int bCount, int cCount, int[][][] dp) {

        if (bCount < 0 || cCount < 0)
            return 0;
        if (n == 0)
            return 1;
        if (bCount == 0 && cCount == 0)
            return 1;

        if (dp[n][bCount][cCount] != -1) {
            return dp[n][bCount][cCount];
        }

        int res = 0;
        res += countStr(n - 1, bCount, cCount, dp);
        res += countStr(n - 1, bCount - 1, cCount, dp);
        res += countStr(n - 1, bCount, cCount - 1, dp);

        return (dp[n][bCount][cCount] = res);
    }

    // O(1)
    static long countStr(long n){
	    return 1 + (n * 2) + (n * ((n * n) - 1) / 2);
	}

    
    public static void main(String[] args) {
        int n = 3; 
        int bCount = 1;
        int cCount = 2;

        int[][][] dp = new int[n+1][bCount+1][cCount+1];
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }

        
        System.out.println(countStr(n, bCount,cCount,dp));
    }
}
