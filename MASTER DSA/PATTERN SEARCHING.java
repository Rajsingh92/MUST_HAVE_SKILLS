// Naive Pattern Searching
public class Solution {
    public static void search(String text , String pattern){
        int m = text.length();
        int n = pattern.length();

        for(int i = 0; i<m-n;i++){
            int j = 0;
            while(j<n){
                if(txt.charAt(i+j)!=pattern.charAt(j))
                    break;
                j++;
            }
            if(j == n){
                System.out.print("Found at"+ i);
            }
        }
    } 
}


// kmp
// rabin karp
// Boyer Moore Algorithm(imp)