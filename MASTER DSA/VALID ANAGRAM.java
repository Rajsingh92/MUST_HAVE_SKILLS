/**
Valid Anagram |  Easy | Amazon, Apple, Facebook, Google, Microsoft |
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */

import java.util.HashMap;


public class Solution{
    public static boolean isAnagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);

            if(!map.containsKey(ch)){
                return false;
            }

            if(map.get(ch) == 1){
                map.remove(ch);
            }else{
                map.put(ch,map.get(ch)-1);
            }
        }

        return map.size() == 0;
    }
}