/**
Group Anagrams |  Medium | Adobe, Affirm, Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all 
the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            HashMap<Character,Integer> fmap =  new HashMap<>();
            for(int i = 0;i<str.length();i++){
                char ch = str.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            
            if(map.containsKey(fmap) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(fmap,list);
            }else{
                ArrayList<String> list = map.get(fmap);
                list.add(str);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for(ArrayList<String> list : map.values()){
            res.add(list);
        }
        
        return res;
    }
}