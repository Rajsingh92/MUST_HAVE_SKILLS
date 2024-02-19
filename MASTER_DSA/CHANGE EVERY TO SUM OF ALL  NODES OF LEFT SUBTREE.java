// Change A Binary Tree So That Every Node Stores Sum Of All Nodes In Left
// Subtree
public class Solution {

    public int updatetree(TreeNode root) {
        if (root == null)
            return 0;

        int leftsum = updatetree(root.left);
        int rightsum = updatetree(root.right);

        root.data += leftsum;

        return root.data + rightsum;
    }
}
