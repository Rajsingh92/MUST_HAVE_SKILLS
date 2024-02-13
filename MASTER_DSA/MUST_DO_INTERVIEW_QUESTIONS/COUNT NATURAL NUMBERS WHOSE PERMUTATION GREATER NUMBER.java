import java.util.*;

public class Solution {
    public static int countNumber(int n){
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i = 1;i<=9;i++){
            if(i <= n){
                st.push(i);
                ans++;
            }

            while(st.size()>0){
                int top = st.pop();
                int j = top % 10;

                while(j <= 9){
                    int num = top*10 + j;
                    if(num <= n){
                        st.push(num);
                        ans++;
                    }
                    j++;
                }
            }
        }

        return ans;
    } 
}
