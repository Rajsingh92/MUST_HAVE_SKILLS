class Solution {
	int maxRepeating(int[] arr, int n, int k) {

		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % k] += k;
		}

		int max = Integer.MIN_VALUE;
		int pos = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				pos = i;
			}
		}

		return pos;
	}
}
