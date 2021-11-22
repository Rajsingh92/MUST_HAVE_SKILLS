/**
Substring with Concatenation of All Words |  Hard | Adobe, Apple, Facebook, Google |

You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
 */


import java.util.*;


public class Solution {

    List<Integer> list = new ArrayList<Integer>();
    HashMap<String, Integer> hm = new HashMap<String, Integer>(); 

    public List<Integer> findSubstring(String s, String[] words) {

        if (s.length() == 0 || s == null || words.length == 0 || words == null
                || s.length() < words.length * words[0].length())
            return list;

        int eachlen = words[0].length();
        int totalLength = words.length * words[0].length();

        for (String e : words) {
            if (hm.containsKey(e)) {
                hm.put(e, hm.get(e) + 1);
            } else {
                hm.put(e, 1);
            }
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {

            String sub = s.substring(i, i + totalLength);
            if (isValid(sub, eachlen))
                list.add(i);

        }

        return list;
    }

    public boolean isValid(String s, int eachlen) {
        HashMap<String, Integer> hmcopy = new HashMap<String, Integer>(hm);

 
        for (int i = 0; i <= s.length() - eachlen; i = i + eachlen) {
            String current = s.substring(i, i + eachlen);

            if (hmcopy.containsKey(current) && hmcopy.get(current) > 0) {
                hmcopy.put(current, hmcopy.get(current) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}

