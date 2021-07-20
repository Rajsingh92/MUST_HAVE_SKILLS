import java.util.*;

public class Main {

    public static boolean solution(String str, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = n; i > ((n + 1) / 2); i--) {
            set.add(i);
        }
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (i >= j) {
                String s = str.substring(j, i + 1);
                int k = Integer.parseInt(s, 2);
                if (k > n) {
                    while (j + 1 < str.length()) {
                        j++;
                        if (str.charAt(j) == '1') {
                            break;
                        }
                    }
                }
                if (set.contains(k)) {
                    set.remove(k);
                }
            }
        }
        return set.size() == 0;
    }

}