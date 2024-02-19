/**
Letter Combinations of a Phone Number |  Medium | Airbnb, Apple, Facebook |

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the 
number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */


import java.util.*;
class Solution {
    String[] codes = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String str) {
        if (str.length() == 0) {
            List<String> bres = new ArrayList<>();
            return bres;
        }

        return getKPC(str);

    }

    public List<String> getKPC(String str) {

        if (str.length() == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        List<String> rres = getKPC(ros);
        List<String> mres = new ArrayList<>();

        String code = codes[ch - '0'];
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            for (String res : rres) {
                mres.add(c + res);
            }
        }

        return mres;

    }
}