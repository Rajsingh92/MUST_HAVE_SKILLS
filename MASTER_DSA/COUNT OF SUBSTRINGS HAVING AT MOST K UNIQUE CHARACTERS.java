/**
Count Of Substrings Having At Most K Unique Characters
 */


public class Main {

    public static int solution(String s, int k) {
        int i = -1;
        int j = -1;
        int ans = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        
        while(true){
            
            //acquire
            while(i<s.length()-1){
                
                i++;
                char ch  = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.size()<=k){
                    ans += i-j;
                }else{
                    break;
                }
            }
            
            if(i == s.length()-1 && map.size() <= k){
                break;
            }
            
            //release
            while(j<i){
                
                j++;
                char ch = s.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                
                if(map.size()>k){
                    continue;
                }else if(map.size() == k){
                    ans += i-j;
                    break;
                }
                
                
            }
            
         
        }
        
        return ans;
    }

}