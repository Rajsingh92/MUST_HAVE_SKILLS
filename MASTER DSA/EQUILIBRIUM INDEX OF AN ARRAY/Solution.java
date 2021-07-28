
class Main {
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1;
        }

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        long rightSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (rightSum == totalSum - rightSum - arr[i]) {
                return i;
            }
            rightSum += arr[i];
        }

        return -1;
    }
}

