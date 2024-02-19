
class Solution {

    void dfs(int v, boolean visited[], LinkedList<Integer> adj[]) {

        visited[v] = true;

        for (int nbr : adj[v]) {
            if (visited[nbr] == false) {
                dfs(nbr, visited);
            }
        }
    }

    int countTrees(LinkedList<Integer> adj[]) {

        boolean visited[] = new boolean[V];
        int ans = 0;

        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                dfs(i, visited, adj);
                ans++;
            }
        }

        return ans;
    }

}
