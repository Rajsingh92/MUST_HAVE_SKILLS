/** 
K ANAGRAM
Check if two strings are k-anagrams or not
Two strings are called k-anagrams if following two conditions are true. 
Both have same number of characters.
Two strings can become anagram by changing at most k characters in a string.

Examples :  
Input:  str1 = "anagram" , str2 = "grammar" , k = 3
Output:  Yes
Explanation: We can update maximum 3 values and it can be done in changing only 'r' to 'n'  and 'm' to 'a' in str2.
 */

public class Solution {
    public static boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length()!=s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;

        for (char ch : map.keySet()) {
            count += map.get(ch);
        }

        if (count > k) {
            return false;
        } else {
            return true;
        }
    }


    public static boolean areKAnagrams2(String str1, String str2, int k) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] farr = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            farr[ch - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (farr[ch - 'a'] != 0)
                farr[ch - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += farr[i];
        }

        if (diff <= k) {
            return true;
        } else {
            return false;
        }
    }
}