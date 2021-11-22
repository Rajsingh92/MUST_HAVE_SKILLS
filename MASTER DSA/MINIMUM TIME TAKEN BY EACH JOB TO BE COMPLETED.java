
public class Solution {

    static final int maxN = 100000;
    static Vector<Integer>[] graph = new Vector[maxN];
    static int[] indegree = new int[maxN];
    static int[] job = new int[maxN];


    static void addEdge(int u, int v) {
        graph[u].add(v);
        indegree[v]++;
    }

    static void printOrder(int n, int m) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                job[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.peek();
            q.remove();

            for (int adj : graph[cur]) {
                indegree[adj]--;

                if (job[adj] < 1 + job[cur]) {
                    job[adj] = Math.max(job[adj], 1 + job[cur]);
                }

                if (indegree[adj] == 0)
                    q.add(adj);
            }
        }


        for (int i = 1; i <= n; i++)
            System.out.print(job[i] + " ");
        System.out.print("\n");
    }

}
