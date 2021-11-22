/**
Letter Case Permutation

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

 

Example 1:

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
 */

import java.util.*;
class Solution {
    public List<String> letterCasePermutation(String str) {

        if (str.length() == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        List<String> rres = letterCasePermutation(ros);
        List<String> mres = new ArrayList<>();

        if (ch >= '0' && ch <= '9') {
            for (String temp : rres) {
                mres.add(ch + temp);
            }
        } else {
            for (String temp : rres) {
                mres.add(Character.toUpperCase(ch) + temp);
                mres.add(Character.toLowerCase(ch) + temp);
            }
        }

        return mres;
    }

    public void letterCasePermutation2(String str, String psf, List<String> res) {
        if (str.length() == 0) {
            res.add(psf);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        if (ch >= '0' && ch <= '9') {
            letterCasePermutation2(ros, psf + ch, res);
            return;
        }

        letterCasePermutation2(ros, psf + Character.toUpperCase(ch), res);
        letterCasePermutation2(ros, psf + Character.toLowerCase(ch), res);
    }
}