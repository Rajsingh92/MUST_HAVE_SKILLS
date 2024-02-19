import java.util.*;

public class Solution {

    private static void solve(String str, int n) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                set.remove(str.charAt(i));
            } else {
                set.add(str.charAt(i));
                if (set.size() > n) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }

}
