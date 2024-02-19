
class Solution {

    public int minimumCostOfCut(int[] X, int[] Y) {
        int res = 0;

        Arrays.sort(X, Collections.reverseOrder());
        Arrays.sort(Y, Collections.reverseOrder());

        int hc = 1, vc = 1;

        int i = 0, j = 0;
        while (i < X.length && j < Y.length) {
            if (X[i] > Y[j]) {
                res += X[i] * vc;
                hc++;
                i++;
            } else {
                res += Y[j] * hc;
                vc++;
                j++;
            }
        }

        int total = 0;
        while (i < X.length) {
            total += X[i];
            i++;
        }

        res += total * vc;

        total = 0;
        while (j < Y.length) {
            total += Y[j];
            j++;
        }

        res += total * hc;

        return res;
    }
}
