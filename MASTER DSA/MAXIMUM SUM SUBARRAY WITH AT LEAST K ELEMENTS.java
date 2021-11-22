import java.util.*;

class Main {

	public static int solution(int[] arr, int k) {
		int currSum = arr[0];
		int[] maxSum = new int[arr.length];
		maxSum[0] = currSum;

		int ans = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (currSum > 0) {
				currSum += arr[i];
			} else {
				currSum = arr[i];
			}

			maxSum[i] = currSum;
		}

		int exactK = 0;
		for (int i = 0; i < k; i++) {
			exactK += arr[i];
		}

		if (exactK > ans) {
			ans = exactK;
		}

		for (int i = k; i < arr.length; i++) {
			exactK += arr[i] - arr[i - k];

			if (exactK > ans) {
				ans = exactK;
			}

			int moreThanK = exactK + maxSum[i - k];
			if (moreThanK > ans) {
				ans = moreThanK;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(solution(arr, k));
	}
}