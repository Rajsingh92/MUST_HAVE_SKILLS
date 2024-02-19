/**
You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.

IP : 0 1 0 2 0 1 0
OP : 3
 */



public class Main {

    public static int solution(int[] arr) {
        int zcount = 0,ocount=0,tcount=0;
        int deleta10 = ocount-zcount;
        int deleta21 = tcount-ocount;
        
        String key = deleta10+"#"+deleta21;
        
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put(key,-1);
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                zcount+=1;
            }else if(arr[i] == 1){
                ocount+=1;
            }else{
                tcount+=1;
            }
            
            deleta10 = ocount-zcount;
            deleta21 = tcount-ocount;
            key = deleta10+"#"+deleta21;
            
            if(map.containsKey(key)){
                int idx = map.get(key);
                int len = i-idx;
                if(len>ans){
                    ans = len;
                }
            }else{
                map.put(key,i);
            }
        }
        
        return ans;
    }
}




/**
You have to find the count of subarrays with equal number of 0s, 1s, and 2s.

IP : 0 1 0 2 0 1 0
OP : 2
 */

public class Main {

    public static int solution(int[] arr) {
        int zcount = 0,ocount=0,tcount=0;
        int deleta10 = ocount-zcount;
        int deleta21 = tcount-ocount;
        
        String key = deleta10+"#"+deleta21;
        
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put(key,1);
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                zcount+=1;
            }else if(arr[i] == 1){
                ocount+=1;
            }else{
                tcount+=1;
            }
            
            deleta10 = ocount-zcount;
            deleta21 = tcount-ocount;
            key = deleta10+"#"+deleta21;
            
            if(map.containsKey(key)){
                ans += map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        
        return ans;
    }

}