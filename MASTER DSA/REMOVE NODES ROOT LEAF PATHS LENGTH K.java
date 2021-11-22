
class Solution {
    Node removeShortPathNodesUtil(Node node, int level, int k) {

        if (node == null)
            return null;

        node.left = removeShortPathNodesUtil(node.left, level + 1, k);
        node.right = removeShortPathNodesUtil(node.right, level + 1, k);

        if (node.left == null && node.right == null && level < k)
            return null;

        return node;
    }

    Node removeShortPathNodes(Node node, int k) {
        int pathLen = 0;
        return removeShortPathNodesUtil(node, 1, k);
    }
}
