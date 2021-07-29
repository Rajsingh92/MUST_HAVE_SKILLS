class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (queue.size() != 0) {

            int size = queue.size();
            int i = 0;

            while (i < size) {
                TreeNode node = queue.removeFirst();
                i++;
                if (i == 1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }

            }

        }

        return res;
    }
}
