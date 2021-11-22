import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

    private static boolean solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * arr[i];
        }

        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 0) {
                continue;
            }
            if (arr[i] >= 0) {
                if (arr[i] == 0 && ((map.get(0) % 2) != 0)) {
                    return false;
                } else if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) < map.get(arr[i])) {
                    return false;
                } else {
                    if (map.containsKey(arr[i]) && map.containsKey(arr[i] * 2)) {
                        int min = Math.min(map.get(arr[i]), map.get(arr[i] * 2));
                        map.put(arr[i], map.get(arr[i]) - min);
                        map.put(arr[i] * 2, map.get(arr[i] * 2) - min);
                    } else {
                        return false;
                    }
                }
            } else {
                if (map.containsKey(arr[i] / 2) && map.get(arr[i] / 2) < map.get(arr[i])) {
                    return false;
                } else {
                    if (map.containsKey(arr[i]) && map.containsKey(arr[i] / 2)) {
                        int min = Math.min(map.get(arr[i]), map.get(arr[i] / 2));
                        map.put(arr[i], map.get(arr[i]) - min);
                        map.put(arr[i] / 2, map.get(arr[i] / 2) - min);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}