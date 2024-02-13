public class Solution {
    // Binary Tree Postorder Traversal | Amazon |
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode root, List<Integer> res) {

        if (root.left != null) {
            postorderTraversal(root.left, res);
        }

        if (root.right != null) {
            postorderTraversal(root.right, res);
        }

        res.add(root.val);
    }

    public List<Integer> postorderTraversal_Iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (st.size() > 0) {
            TreeNode rem = st.pop();
            res.add(0, rem.val);

            if (rem.left != null) {
                st.push(rem.left);
            }

            if (rem.right != null) {
                st.push(rem.right);
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal_MorrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        // todo

        return res;
    }
}
