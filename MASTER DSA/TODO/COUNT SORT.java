// Count Sort

public class Main {

	public static int[] countSort(int[] arr, int min, int max) {
		int range = max - min + 1;
		int[] farr = new int[range];
		for (int i = 0; i < arr.length; i++) {
			farr[arr[i] - min]++;
		}

		for (int i = 1; i < farr.length; i++) {
			farr[i] += farr[i - 1];
		}

		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int idx = farr[arr[i] - min] - 1;
			ans[idx] = arr[i];
			farr[arr[i] - min]--;
		}

		return ans;
	}

	// Sort an character array
	public static void countSort2(char[] arr) {

		int[] farr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			farr[arr[i] - 'a']++;
		}

		for (int i = 1; i < farr.length; i++) {
			farr[i] += farr[i - 1];
		}

		char[] ans = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (farr[arr[i] - 'a'] >= 1) {
				ans[farr[arr[i] - 'a'] - 1] = (char) arr[i];
				farr[arr[i] - 'a']--;
			}
		}

		for (char ch : ans) {
			System.out.print(ch);
		}
	}
}
