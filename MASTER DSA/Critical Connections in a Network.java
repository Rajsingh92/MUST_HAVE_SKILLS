public class Q1192 {
    // 1192 | 1192 | Critical Connections in a Network | Hard | Amazon |
    ArrayList<Integer>[] graph;

    int time = 0;
    int[] low;
    int[] disc;
    boolean vis[];

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        low = new int[n];
        disc = new int[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> a : connections) {
            graph[a.get(0)].add(a.get(1));
            graph[a.get(1)].add(a.get(0));
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs_AB(i, -1);
            }
        }

        return ans;
    }

    public void dfs_AB(int src, int par) {
        low[src] = disc[src] = time++;
        vis[src] = true;
        for (int e : graph[src]) {
            if (!vis[e]) {
                dfs_AB(e, src);
                if (disc[src] < low[e]) {

                    ArrayList<Integer> smallAns = new ArrayList<>();
                    smallAns.add(src);
                    smallAns.add(e);
                    ans.add(smallAns);
                }

                low[src] = Math.min(low[src], low[e]);
            } else if (e != par) {
                low[src] = Math.min(low[src], disc[e]);
            }
        }
    }
}
