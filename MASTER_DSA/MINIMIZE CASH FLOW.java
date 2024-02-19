
public class Solution {

    static final int N = 3;

    static int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    static int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    static void minCashFlowRec(int amount[]) {
        int mxCredit = getMax(amount), mxDebit = getMin(amount);

        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        int min = Math.min(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        System.out.println("Person " + mxDebit + " pays " + min + " to " + "Person " + mxCredit);

        minCashFlowRec(amount);
    }

    static void minCashFlow(int graph[][]) {
        int amount[] = new int[N];
        for (int p = 0; p < N; p++)
            for (int i = 0; i < N; i++)
                amount[p] += (graph[i][p] - graph[p][i]);

        minCashFlowRec(amount);
    }

    public static void main(String[] args) {

        int graph[][] = { { 0, 1000, 2000 }, { 0, 0, 5000 }, { 0, 0, 0 }, };
        minCashFlow(graph);
    }

}
