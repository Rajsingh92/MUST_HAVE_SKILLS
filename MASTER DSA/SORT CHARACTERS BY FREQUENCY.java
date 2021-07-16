/**
Sort Characters By Frequency |  Medium | Amazon, Google, Microsoft |
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */

import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            return map.get(b)-map.get(a);
        });
        
        for(Character ch : map.keySet()){
            pq.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size()!=0){
            char ch = pq.remove();
            int freq = map.get(ch);
            for(int i =0;i<freq;i++){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}