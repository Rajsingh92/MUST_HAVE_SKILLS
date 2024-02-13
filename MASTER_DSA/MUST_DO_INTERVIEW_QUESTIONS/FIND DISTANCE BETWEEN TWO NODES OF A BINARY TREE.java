class Solution {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return root;
        if (root.value == n1 || root.value == n2)
            return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;

        if (left != null)
            return LCA(root.left, n1, n2);
        else
            return LCA(root.right, n1, n2);
    }

    public static int findLevel(Node root, int a, int level) {
        if (root == null)
            return -1;
        if (root.value == a)
            return level;
        int left = findLevel(root.left, a, level + 1);

        if (left == -1)
            return findLevel(root.right, a, level + 1);

        return left;
    }

    public static int findDistance(Node root, int a, int b) {
        Node lca = LCA(root, a, b);

        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);

        return d1 + d2;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        i++;
        j++;

        return i + j;
    }
}
