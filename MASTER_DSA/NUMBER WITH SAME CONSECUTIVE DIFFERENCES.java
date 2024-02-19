//  Numbers With Same Consecutive Differences

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(N, K, i, i, res, 1);
        }

        int[] mres = new int[res.size()];
        int k = 0;
        for (int temp : res) {
            mres[k++] = temp;
        }

        return mres;
    }

    public void dfs(int N, int K, int prevNum, int currRes, ArrayList<Integer> res, int count) {
        if (count == N) {
            res.add(currRes);
            return;
        }

        // prevNum+k
        if (prevNum + K < 10) {
            int digit = prevNum + K;
            dfs(N, K, digit, currRes * 10 + digit, res, count + 1);
        }

        // prevNum-k
        if (K != 0 && prevNum - K >= 0) {
            int digit = prevNum - K;
            dfs(N, K, digit, currRes * 10 + digit, res, count + 1);
        }
    }
}


