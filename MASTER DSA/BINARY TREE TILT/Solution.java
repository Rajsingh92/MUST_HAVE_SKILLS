class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int tilt = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }

    public int sum(TreeNode root) {
        if (root == null)
            return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        tilt += Math.abs(left - right);

        return root.val + left + right;
    }

}

