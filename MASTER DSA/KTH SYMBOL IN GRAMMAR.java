/**
K-th Symbol in Grammar

On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each 
occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
 */

class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int mid = (1 << N - 1) >> 1;

        if (K <= mid) {
            return kthGrammar(N - 1, K);
        } else {
            if (kthGrammar(N - 1, K - mid) == 0)
                return 1;
            else
                return 0;
        }
    }
}

// Finding Profession            
// https://practice.geeksforgeeks.org/problems/finding-profession/0

class Solution {
    static char profession(int level, int pos) {
        if (level == 1)
            return 'e';

        if (profession(level - 1, (pos + 1) / 2) == 'd')
            return (pos % 2 > 0) ? 'd' : 'e';
        else
            return (pos % 2 > 0) ? 'e' : 'd';

    }
}