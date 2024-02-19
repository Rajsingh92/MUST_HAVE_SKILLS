import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        long ans = countSubsequences(str);
        System.out.println(ans - 1);

    }

    public static long countSubsequences(String str) {
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = str.charAt(i - 1);
            if (map.containsKey(ch)) {
                int lastOccur = map.get(ch);
                dp[i] = dp[i] - dp[lastOccur - 1];
            }

            map.put(ch, i);
        }

        return dp[str.length()];
    }
}