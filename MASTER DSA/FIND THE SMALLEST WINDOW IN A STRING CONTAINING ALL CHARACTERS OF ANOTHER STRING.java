/**
Find the smallest window in a string containing all characters of another string 

Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum 
window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
 */

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        int matchCount = 0;
        int desiredCount = t.length();
        String ans = "";
        
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
             // acquire
             while(i<s.length()-1 && matchCount<desiredCount){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                    matchCount++;
                }
                f1 = true;
             }
             
             // collect ans and release
            while(j<i && matchCount==desiredCount){
                // collect
                String potentialRes = s.substring(j+1,i+1);
                if(ans.length() == 0 || ans.length()>potentialRes.length()){
                    ans = potentialRes;
                }
                
                
                //release
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }
                
                if(map1.getOrDefault(ch,0)< map2.getOrDefault(ch,0)){
                    matchCount--;
                }
                
                
                f2 = true;
            }
            
            if( f1 ==false && f2 == false){
                break;
            }
         }
        return ans;
    }
    
}
