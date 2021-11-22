import java.util.*;

public class Solution {

	public static void solve(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]) == false)
				map.put(arr[i], 1);
			else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++) {
				if (arr[i] % arr[j] == 0) {
					int result = arr[i] / arr[j];
					if (map.containsKey(result) && result != arr[j]) {
						if (map.get(result) > 0) {
							System.out.println(arr[i]);
							return;
						}
					} else if (map.containsKey(result) && result == arr[j]) {
						if (map.get(result) > 1) {
							System.out.println(arr[i]);
							return;
						}
					}
				}
			}
		}

		System.out.println(-1);
	}
}
