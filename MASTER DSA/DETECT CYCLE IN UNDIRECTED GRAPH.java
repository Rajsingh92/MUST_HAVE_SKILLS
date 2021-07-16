/**
Detect cycle in an undirected graph 
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
 */

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vtces = adj.size();
        boolean[] visited = new boolean[vtces];

        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                boolean cyclic = IsCyclic(adj, visited, v);
                if (cyclic) {
                    return cyclic;
                }
            }
        }

        return false;
    }

    public static boolean IsCyclic(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (queue.size() > 0) {
            int rem = queue.remove();

            if (visited[rem]) {
                return true;
            }

            visited[rem] = true;

            ArrayList<Integer> e = adj.get(rem);
            for (int i = 0; i < e.size(); i++) {
                if (!visited[e.get(i)]) {
                    queue.add(e.get(i));
                }
            }
        }

        return false;
    }

    // dfs 
    // union find
    // directed
}