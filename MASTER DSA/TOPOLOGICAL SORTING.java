
public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, boolean[] visited, int src, Stack<Integer> st) {
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false)
                topologicalSort(graph, visited, e.nbr, st);
        }

        st.push(src);
    }

    public static void KahnsAlgo() {
        int[] indegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (Integer e : graph[i])
                indegree[e]++;
        }

        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0)
                que.addLast(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                ans.add(rvtx);

                for (int e : graph[rvtx]) {
                    if (--indegree[e] == 0)
                        que.addLast(e);
                }
            }
        }

        if (ans.size() != N)
            System.out.println("Cycle");
        else
            System.out.println(ans);
    }

    public static void main(String[] args) {

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();

        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                topologicalSort(graph, visited, v, st);
            }
        }

        while (st.size() > 0) {
            System.out.println(st.pop());
        }

    }

}




