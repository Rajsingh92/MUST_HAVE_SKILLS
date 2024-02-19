import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }

    static int count;

    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                dfs(adj, visited, i, st);
            }
        }

        int potentialMother = st.pop();
        visited = new boolean[N];

        count = 0;
        dfs2(adj, visited, potentialMother);

        if (count == N) {
            return potentialMother + 1;
        } else {
            return -1;
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v, Stack<Integer> st) {
        visited[v] = true;

        for (int nbr : adj.get(v)) {
            if (visited[nbr] == false) {
                dfs(adj, visited, nbr, st);
            }
        }

        st.push(v);
    }

    public static void dfs2(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v) {
        visited[v] = true;
        count++;

        for (int nbr : adj.get(v)) {
            if (visited[nbr] == false) {
                dfs2(adj, visited, nbr);
            }
        }
    }
}