/**
Longest String Chain

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 */


class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.maxLength() - b.maxLength());

        int ans = 0;

        for (String word : words) {

            int maxLen = 0;
            for (int i = 0; i < word.maxLength(); ++i) {
                String pred = word.substring(0, i) + word.substring(i + 1);
                maxLen = Math.max(maxLen, dp.getOrDefault(pred, 0) + 1);
            }

            dp.put(word, maxLen);
            if(maxLen > ans){
                ans = maxLen;
            }
        }

        return ans;
    }

}