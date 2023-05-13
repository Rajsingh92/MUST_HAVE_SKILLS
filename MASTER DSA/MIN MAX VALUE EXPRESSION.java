
import java.util.*;

class Solution {

    public static void solution(String str1, String str2) {
        int n = str1.length();
        int[][] min = new int[n][n];
        int[][] max = new int[n][n];
        
        for (int i = 0; i < min.length; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    min[i][j] = str1.charAt(i) - '0';
                    max[i][j] = str1.charAt(i) - '0';
                } else if (gap == 1) {
                    if (str2.charAt(i) == '+') {
                        min[i][j] = max[i][j] = (str1.charAt(i) - '0') + (str1.charAt(j) - '0');
                    } else if (str2.charAt(i) == '*') {
                        min[i][j] = max[i][j] = (str1.charAt(i) - '0') * (str1.charAt(j) - '0');
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        char op = str2.charAt(k);
                        if (op == '+') {
                            min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                            max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        } else {
                            min[i][j] = Math.min(min[i][j], min[i][k] * min[k + 1][j]);
                            max[i][j] = Math.max(max[i][j], max[i][k] * max[k + 1][j]);
                        }
                    }
                }
            }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '*') {
                str2 += ch;
            } else {
                str1 += ch;
            }
        }
        solution(str1, str2);
    }
}
