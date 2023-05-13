public class Solution {
    // Binary Tree Preorder Traversal | Medium | Google |

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res) {

        res.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, res);
        }

        if (root.right != null) {
            preorderTraversal(root.right, res);
        }
    }

    public List<Integer> preorderTraversal_Iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (st.size() > 0) {
            TreeNode rem = st.pop();
            res.add(rem.val);

            if (rem.right != null) {
                st.push(rem.right);
            }

            if (rem.left != null) {
                st.push(rem.left);
            }
        }

        return res;
    }

    public List<Integer> preorderTraversal_MorrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode curr = root;

        while (curr != null) {
            res.add(curr.val);

            if (curr.left != null) {
                TreeNode temp = curr.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = curr.right;
                curr.right = null;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return res;
    }
}
