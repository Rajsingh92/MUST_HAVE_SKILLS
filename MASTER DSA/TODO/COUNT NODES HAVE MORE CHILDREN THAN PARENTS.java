
public class Solution {

    static int countNodes(Integer<int[]>[] adj, int root) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int node = queue.removeFirst();

            for (Node children : adj[node]) {
                if (adj[children].size() > adj[node].size()) {
                    count++;
                }

                queue.addLast(children);
            }
        }

        return count;
    }

}
