
/**
Number following a pattern 
Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Digits from 1-9 and digits can't repeat.

Input
5
D
I
DD
IIDDD
DDIDDIID

Output
21
12
321
126543
321654798
 */

import java.util.*;

class Solution {

    public static String sequence(String str) {
        String ans = "";

        Stack < Integer > st = new Stack < > ();

        int num = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;

                while (st.size() > 0) {
                    //System.out.print(st.pop());
                    ans+=Integer.toString(st.pop());
                }
            }
        }

        st.push(num);
        while (st.size() > 0) {
            //System.out.print(st.pop());
            ans+=Integer.toString(st.pop());
        }

        return ans;
    }
}