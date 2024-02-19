// Print all nodes that don’t have sibling
class Solution {
    public void printSingle(TreeNode root) {

        if (root.left != null && root.right == null) {
            System.out.print(root.data);
            printSingle(root.left);
        } else if (root.left == null && root.right != null) {
            System.out.print(root.data);
            printSingle(root.right);
        } else {
            printSingle(root.left);
            printSingle(root.right);
        }
    }
}
