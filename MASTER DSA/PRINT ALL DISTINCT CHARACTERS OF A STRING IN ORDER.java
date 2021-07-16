// Source: https://www.geeksforgeeks.org/print-all-distinct-characters-of-a-string-in-order-3-methods/

class Solution {

    public static void printDistinct(String str) {
        int n = str.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            char x = str.charAt(i);
            int x1 = (int) (x - 'a');
            count[x1]++;
        }

        for (int i = 0; i < n; i++) {
            char x = str.charAt(i);
            int x1 = count[(x - 'a')];

            if (x1 == 1) {
                System.out.print(x);
            }
        }
    }
}