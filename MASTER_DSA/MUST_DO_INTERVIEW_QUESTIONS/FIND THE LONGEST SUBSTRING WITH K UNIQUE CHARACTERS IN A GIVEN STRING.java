/**
Find the longest substring with k unique characters in a given string
Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.
Examples:

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.
 */


public class Main {

    public static int solution(String str, int k) {
        int ans = 0;
        int i  = -1;
        int j =  -1;
        HashMap<Character,Integer> map  = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while(i<str.length()-1){
                f1 = true;
                
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.size()<k){
                    continue;
                }else if(map.size() == k){
                    int len = i-j;
                    ans = Math.max(ans,len);
                }else{
                    break;
                }
            }
            //release
            while(j<i){
                f2 = true;
                
                j++;
                char ch = str.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                
                if(map.size()>k){
                    continue;
                }else if(map.size() == k){
                    int len = i-j;
                    ans = Math.max(ans,len);
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