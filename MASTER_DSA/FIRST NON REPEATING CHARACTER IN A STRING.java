// Source: https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/

public class Solution {
    // get in one traversal
    public static char getprob(String str) {
        int[] count = new int[26];
        int[] index = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int x = (int) (ch - 'a');
            count[x]++;
            index[x] = i;
        }

        int min_ind = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                if (min_ind > index[i]) {
                    min_ind = index[i];
                }
            }
        }

        return str.charAt(min_ind);
    }
}
