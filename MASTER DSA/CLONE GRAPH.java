/**
Clone Graph  | Amazon, Facebook |

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 */

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node rem = queue.removeFirst();

            for (Node neighbor : rem.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                map.get(rem).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}