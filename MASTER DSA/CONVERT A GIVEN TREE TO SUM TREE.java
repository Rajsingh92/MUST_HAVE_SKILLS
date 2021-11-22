// Convert A Given Tree To Sum Tree
class Solution {
    public void toSumTree(Node root) {
        if (root == null) {
            return;
        }

        getSumTree(root);
    }

    public int getSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int oldVal = root.data;

        int left = getSumTree(root.left);
        int right = getSumTree(root.right);
        root.data = left + right;

        return root.data + oldVal;
    }
}
