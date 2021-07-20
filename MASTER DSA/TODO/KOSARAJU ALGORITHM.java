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

        System.out.println(kosaraju(graph, n));
    }

    static int count;

    public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int N) {
        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                dfs(graph, i, visited, st);
            }
        }

        // reverse all edges -- transpose of graph
        ArrayList<ArrayList<Integer>> newGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            newGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int nbr : graph.get(i)) {
                newGraph.get(nbr).add(i);
            }
        }

        visited = new boolean[N];
        count = 0;
        while (st.size() > 0) {
            int v = st.pop();
            if (visited[v] == false) {
                dfs(newGraph, v, visited);
                count++;
            }
        }

        return count;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, Stack<Integer> st) {
        visited[v] = true;

        for (int nbr : graph.get(v)) {
            if (visited[nbr] == false) {
                dfs(graph, nbr, visited, st);
            }
        }

        st.push(v);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;

        for (int nbr : graph.get(v)) {
            if (visited[nbr] == false) {
                dfs(graph, nbr, visited);
            }
        }

    }

}
