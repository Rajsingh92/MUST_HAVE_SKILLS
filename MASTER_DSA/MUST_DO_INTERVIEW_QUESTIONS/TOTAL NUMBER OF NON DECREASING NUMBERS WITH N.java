
class Main {

    public static long countNonDecreasing(int n) {
        int N = 10;
        long count = 1;

        for (int i = 1; i <= n; i++) {
            count *= (N + i - 1);
            count /= i;
        }

        return count;
    }
}


