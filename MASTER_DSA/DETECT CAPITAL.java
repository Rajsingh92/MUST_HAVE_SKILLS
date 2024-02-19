/**
Detect Capital

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 */

class Solution {

    public boolean detectCapitalUse(String word) {

        int noc = 0, nos = 0;

        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                noc++;
            } else {
                nos++;
            }
        }

        char ch = word.charAt(0);
        if (ch >= 'A' && ch <= 'Z' && noc == word.length() - 1) {
            return true;
        }

        if (ch >= 'A' && ch <= 'Z' && nos == word.length() - 1) {
            return true;
        }

        if (ch >= 'a' && ch <= 'z' && nos == word.length() - 1) {
            return true;
        }

        return false;
    }
}