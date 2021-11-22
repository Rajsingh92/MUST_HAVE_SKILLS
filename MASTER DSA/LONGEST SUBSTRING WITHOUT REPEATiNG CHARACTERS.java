/**
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i = -1;
        int j = -1;
        int ans = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while(i<s.length()-1){
                f1 = true;
                i++;
                char ch  = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.get(ch) == 2){
                    break;
                }else{
                    int len = i-j;
                    ans = Math.max(ans,len);
                }
            }
            
            //release
            while(j<i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch) == 1){
                    break;
                }
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return ans;
    }
}