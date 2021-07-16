/**
Group Shifted Strings |  Medium | Apple |
Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Input : acd dfg wyz yab mop bdfh a x moqs
output: 
    acd dfg mop wyz yab 
    a x 
    bdfh moqs 
 */


public class Main {
    
    public static String getKey(String str){
        String key = " ";
        
        for(int i = 1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            int diff = curr-prev;
            if(diff<0){
                diff+=26;
            }
            
            key += diff+"#";
        }
        
        key+=".";
        return key;
    }

    public static ArrayList < ArrayList < String >> groupShiftedStrings(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            String key = getKey(str);
            
            if(map.containsKey(key) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else{
                ArrayList<String> list = map.get(key);
                list.add(str);
            }
        }
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        for(ArrayList<String> list: map.values()){
            res.add(list);
        }
        
        return res;
    }

}