
class Solution {

    public static int bfs(int[] blocked, boolean[] visited, Vector<Integer>[] adjList, int src) {

        visited[src] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        int count = 0;
        while (!q.isEmpty()) {
            int p = q.remove();

            for (int i = 0; i < adjList[p].size(); i++) {
                int nbr = adjList[p].get(i);
                if (visited[nbr] == false && blocked[nbr] == 0) {
                    visited[nbr] = true;
                    q.add(nbr);
                    count++;
                } else if (visited[nbr] == false && blocked[nbr] == 1) {
                    count++;
                }
            }
        }

        return count + 1;
    }

    static int solve(int N, int[] blocked, Vector<Integer> adjList[]) {
        boolean[] visited = new boolean[N + 1];
        int max = 1;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && blocked[i] == 0) {
                int res = bfs(blocked, visited, adjList, i);
                if (res > max) {
                    max = res;
                }
            }
        }

        return max;
    }

}
