// Double tree
class Solution {

    public void doubleTree(Node node) {
        if (node == null)
            return;

        doubleTree(node.left);
        doubleTree(node.right);

        Node oldleft = node.left;
        node.left = new Node(node.data);
        node.left.left = oldleft;
    }
}

