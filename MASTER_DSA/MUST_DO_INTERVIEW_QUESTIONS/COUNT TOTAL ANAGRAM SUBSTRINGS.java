/**
Count of total anagram substrings

Given a string of lower alphabet characters, count total substring of this string which are anagram to 
each other.

Examples:

Input  : str = “xyyx”
Output : 4
Total substrings of this string which
are anagram to each other are 4 which 
can be enumerated as,
{“x”, “x”}, {"y", "y"}, {“xy”, “yx”}, 
{“xyy”, “yyx”}

Input  : str = "geeg"
Output : 4
 */

import java.util.*;


public class Solution {
    static void subString(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] valC = s.substring(i, j + 1).toCharArray();
                Arrays.sort(valC);
                String val = new String(valC);
                if (map.containsKey(val))
                    map.put(val, map.get(val) + 1);
                else
                    map.put(val, 1);
            }
        }
        int anagramPairCount = 0;
        for (String key : map.keySet()) {
            int n = map.get(key);
            anagramPairCount += (n * (n - 1)) / 2;
        }
        System.out.println(anagramPairCount);
    }
}





