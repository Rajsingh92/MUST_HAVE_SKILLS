/**
Palindrome Partitioning  | Adobe, Amazon |

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solution(s, new ArrayList<>(), ans);
        return ans;
    }

    public void solution(String str, List<String> curr, List<List<String>> ans) {
        if (str.length() == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String fh = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (isPalindrome(fh)) {
                curr.add(fh);
                solution(ros, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}




/**

// Palindrome Partitioning  | Adobe, Amazon |
public class palindromeparttion {
    public int palindromePartition(int si,int ei,int k,int[][] dp,int[][] pdp){
        if(k == 0) return dp[k][ei] = 0;
        if(k == 1) return dp[k][ei] = pdp[si][ei];
        if(ei - si + 1 <= k) return dp[k][ei] = (ei-si+1 < k) ? (int)1e8 : 0;
        
        if(dp[k][ei] != -1) return dp[k][ei];
        
        int min_ = (int)1e8; 
        for(int cut = si; cut < ei;cut++){
            int recAns = palindromePartition(si,cut,k-1,dp,pdp);
            
            min_ = Math.min(min_, pdp[cut + 1][ei] + recAns);
        }
        
        return dp[k][ei] = min_;
    }
    
    
    public int palindromePartition(String str, int k) {
        if(str.length() == 0 || k == 0 || str.length() <= k) return 0;
        int n = str.length();
        int[][] pdp = new int[n][n];
        
        for(int gap = 1;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                pdp[i][j] = pdp[i+1][j-1];
                if(str.charAt(i) != str.charAt(j)) pdp[i][j]++;
            }
        }
        
        int[][] dp = new int[k + 1][n + 1];
        for(int[] d: dp) Arrays.fill(d,-1);
        
        return palindromePartition(0,n-1,k,dp,pdp);
        
    }
}


//  Palindrome Partitioning III	
//  Palindrome Partitioning IV	


public class Q1278 {
    // Leetcode 1278
    public int palindromePartition(String s, int k, int si, int ei, int[][] dp, int[][] pdp) {
        if (k >= (ei - si + 1)) {
            return dp[k][ei] = (k == (ei - si + 1)) ? 0 : (int) 1e8;
        }

        if (k == 1 || si == ei) {
            return dp[k][ei] = (si == ei) ? 0 : pdp[0][ei];
        }

        if (dp[k][ei] != -1)
            return dp[k][ei];

        int ans = (int) 1e8;
        for (int cut = si; cut < ei; cut++) {
            int recAns = palindromePartition(s, k - 1, si, cut, dp, pdp);

            if (recAns != (int) 1e8)
                ans = Math.min(ans, recAns + pdp[cut + 1][ei]);
        }

        return dp[k][ei] = ans;
    }

    public int palindromePartition(String s, int k) {
        int n = s.length();
        if (k == 0 || k == n)
            return 0;

        int[][] dp = new int[k + 1][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int[][] pdp = new int[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                pdp[i][j] += pdp[i + 1][j - 1];
                if (s.charAt(i) != s.charAt(j))
                    pdp[i][j] += 1;
            }
        }

        int ans = palindromePartition(s, k, 0, n - 1, dp, pdp);
        return ans;
    }
}


public class Q132 {
    // leetcode 132
    public int minCut(String str, int si, int[] dp, boolean[][] isPalindrome) {
        if (si == str.length() || isPalindrome[si][str.length() - 1]) {
            return dp[si] = 0;
        }

        if (dp[si] != -1)
            return dp[si];

        int ans = (int) 1e8;
        for (int cut = si; cut < str.length(); cut++) {
            if (isPalindrome[si][cut]) {
                int MinCutCount = minCut(str, cut + 1, dp, isPalindrome);
                ans = Math.min(ans, MinCutCount + 1);
            }
        }

        return dp[si] = ans;
    }

    public int minCut(String str) {
        if (str.length() <= 1)
            return 0;
        int n = str.length();

        boolean[][] isPalindrome = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    isPalindrome[i][j] = true;
                else if (gap == 1)
                    isPalindrome[i][j] = str.charAt(i) == str.charAt(j);
                else
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (str.charAt(i) == str.charAt(j));
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minCut(str, 0, dp, isPalindrome);
    }

    // leetcode 132.===========================================================
    // Time: O(n3)
    public static int minCut_(int st, int end, int[][] dp, boolean[][] isPalindrome) {
        if (st == end || isPalindrome[st][end])
            return dp[st][end] = 0;

        if (dp[st][end] != -1)
            return dp[st][end];

        int min_ = (int) 1e8;
        for (int cut = st; cut < end; cut++) {
            int leftMinCut = isPalindrome[st][cut] ? 0 : minCut_(st, cut, dp, isPalindrome);
            int rightMinCut = isPalindrome[cut + 1][end] ? 0 : minCut_(cut + 1, end, dp, isPalindrome);

            int myCost = leftMinCut + 1 + rightMinCut;
            min_ = Math.min(min_, myCost);
        }

        return dp[st][end] = min_;
    }

    // Time: O(n2)
    public static int minCut_02(int st, int end, int[] dp, boolean[][] isPalindrome) {
        if (st > end)
            return -1;
        if (dp[st] != -1)
            return dp[st];

        int min_ = (int) 1e8;
        for (int cut = st; cut <= end; cut++) {
            if (isPalindrome[st][cut]) {
                int cuts_ = minCut_02(cut + 1, end, dp, isPalindrome) + 1;
                min_ = Math.min(min_, cuts_);
            }
        }

        return dp[st] = min_;
    }

    public static int minCut_02_DP(int st, int end, int[] dp, boolean[][] isPalindrome) {
        for (st = end; st >= 0; st--) {
            int min_ = (int) 1e8;
            for (int cut = st; cut <= end; cut++) {
                if (isPalindrome[st][cut]) {
                    int cuts_ = ((cut + 1 == end + 1) ? -1 : dp[cut + 1]) + 1;
                    min_ = Math.min(min_, cuts_);
                }
            }

            dp[st] = min_;
        }
        return dp[0];
    }

    public static int minCut2(String str) {
        int n = str.length();
        int[] dp = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++)
            dp[i] = -1;

        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {
                if (gap == 0)
                    isPalindrome[si][ei] = true;
                else if (str.charAt(si) == str.charAt(ei) && gap == 1)
                    isPalindrome[si][ei] = true;
                else
                    isPalindrome[si][ei] = str.charAt(si) == str.charAt(ei) && isPalindrome[si + 1][ei - 1];
            }
        }

        return minCut_02(0, n - 1, dp, isPalindrome);
    }

     // leetcode 1278
     public int[][] minChanges(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 0 : 1;
                else
                    dp[i][j] = str.charAt(i) != str.charAt(j) ? dp[i + 1][j - 1] + 1 : dp[i + 1][j - 1];
            }
        }
        return dp;
    }

    public int palindromePartition_(String str, int k, int si, int[][] dp, int[][] minChange) {
        if (str.length() - si <= k) {
            return dp[si][k] = (str.length() - si == k) ? 0 : (int) 1e9;
        }

        if (k == 1)
            return dp[si][k] = minChange[si][str.length() - 1];
        if (dp[si][k] != -1)
            return dp[si][k];

        int minAns = (int) 1e9;
        for (int i = si; i < str.length() - 1; i++) {
            int minChangesInMySet = minChange[si][i];
            int minChangesInRecSet = palindromePartition_(str, k - 1, i + 1, dp, minChange);
            if (minChangesInRecSet != (int) 1e9)
                minAns = Math.min(minAns, minChangesInRecSet + minChangesInMySet);
        }

        return dp[si][k] = minAns;
    }

    public int palindromePartition(String str, int k) {
        int[][] minChangeDP = minChanges(str);
        int[][] dp = new int[str.length()][k + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return palindromePartition_(str, k, 0, dp, minChangeDP);
    }

}

 */