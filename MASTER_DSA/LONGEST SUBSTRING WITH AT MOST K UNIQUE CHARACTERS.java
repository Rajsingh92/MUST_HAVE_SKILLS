/**
Longest Substring With At Most K Unique Characters
 */


public class Main {

    public static int solution(String s, int k) {
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
                
                if(map.size()<=k){
                    ans = Math.max(ans,i-j);
                }else{
                    break;
                }
            }
            
            //release
            while(j<i){
                f2 = true;
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
                    ans = Math.max(ans,i-j);
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