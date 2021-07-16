import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            set.add(arr[i]);
        }
        System.out.println(solution(arr, set.size()) - solution(arr, set.size() - 1));
    }

    public static int solution(int[] arr, int K) {
        int j = 0, res = 0;
        Map < Integer, Integer > map = new HashMap < > ();
        for (int i = 0; i < arr.length; i++) {
            if (map.getOrDefault(arr[i], 0) == 0) K--;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (K < 0) {
                map.put(arr[j], map.get(arr[j]) - 1);
                if (map.get(arr[j]) == 0) K++;
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }

}