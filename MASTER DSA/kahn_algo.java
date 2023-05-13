
public class Main {
 

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
}




