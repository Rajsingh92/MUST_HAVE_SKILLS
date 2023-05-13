/**
Word Pattern |  Easy | Google, Microsoft |
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length()){
            return false;
        }
        
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Boolean> used = new HashMap<>();
        
        for(int i = 0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch) == false){
                if(used.containsKey(words[i]) == true){
                    return false;
                }
                map.put(ch,words[i]);
                used.put(words[i],true);
            }else{
                String mappedWith = map.get(ch);
                if(mappedWith.equals(words[i]) == false){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}

/**
Word Pattern II |  Hard | Facebook |

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab", str = "ss", return false.)

You may assume both pattern and str contains only lowercase letters.

Example
Example 1

Input:
pattern = "abab"
str = "redblueredblue"
Output: true
Explanation: "a"->"red","b"->"blue"
 */



public class Solution {

    public boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> inverseMap = new HashMap<>();

        return dfs(pattern, 0, str, 0, map, inverseMap);
    }

    boolean dfs(String pattern, int pattenIndex, String str, int strIndex, HashMap<Character, String> map,
            HashMap<String, Character> inverseMap) {

        if (pattenIndex == pattern.length() && strIndex == str.length()) {
            return true;
        }
        if (pattenIndex == pattern.length() || strIndex == str.length()) { 
            return false;
        }

        char patternChar = pattern.charAt(pattenIndex);

        for (int i = strIndex; i < str.length(); ++i) {
            String tentativeMatchString = str.substring(strIndex, i + 1);

            if (map.containsKey(patternChar) && map.get(patternChar).equals(tentativeMatchString)) {
                if (dfs(pattern, pattenIndex + 1, str, i + 1, map, inverseMap)) {
                    return true;
                }

            } else if (!map.containsKey(patternChar)) {

                if (!inverseMap.containsKey(tentativeMatchString)) { 
                    map.put(patternChar, tentativeMatchString);
                    inverseMap.put(tentativeMatchString, patternChar);

                    if (dfs(pattern, pattenIndex + 1, str, i + 1, map, inverseMap)) {
                        return true;
                    }

                    map.remove(patternChar); 
                    inverseMap.remove(tentativeMatchString);
                }
            }
        }

        return false;
    }
}

