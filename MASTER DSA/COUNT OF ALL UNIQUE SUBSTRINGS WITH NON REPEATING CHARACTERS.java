/**
 * 
Count of all unique substrings with non-repeating characters
Given a string str consisting of lowercase characters, the task is to find the total numbers of unique 
substrings with non-repeating characters.

Examples:

Input: str = “abba”
Output: 4
Explanation:
There are 4 unique substrings. They are: “a”, “ab”, “b”, “ba”.
 */

public class Main {

    public static int solution(String str) {
        int ans = 0;
        int i =-1;
        int j = -1;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
           // acquire
           while(i<str.length()-1){
               f1 = true;
               
               i++;
               char ch = str.charAt(i);
               map.put(ch,map.getOrDefault(ch,0)+1);
               
               if(map.get(ch) == 2){
                   break;
               }else{
                   ans += i-j;
               }
               
           }
           
           //release
           while(j<i){
               f2 = true;
               
               j++;
               char ch = str.charAt(j);
               map.put(ch,map.get(ch)-1);
               
               if(map.get(ch) == 1){
                   ans += i-j;
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
