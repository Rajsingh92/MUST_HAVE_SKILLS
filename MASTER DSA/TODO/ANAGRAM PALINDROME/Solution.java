import java.util.*;

class Sol {
    int isPossible(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int countInvalid = 0;

        for (Character key : map.keySet()) {
            int freq = map.get(key);

            if (freq % 2 != 0) {
                countInvalid++;
            }
        }

        return countInvalid <= 1 ? 1 : 0;
    }
}

