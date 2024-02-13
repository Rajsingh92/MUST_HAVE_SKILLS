
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }

    public static boolean printAncestors(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.data == target) {
            return true;
        }

        boolean left = printAncestors(root.left, target);
        boolean right = printAncestors(root.right, target);
        
        if (left || right) {
            Syetem.out.print(root.data);
            return true;
        }

        return false;
    }

    public static void findCommonNodes(TreeNode root, int first, int second) {
        TreeNode LCA = findLCA(root, first, second);
        if (LCA == null)
            return;
        printAncestors(root, LCA.data);
    }
}
