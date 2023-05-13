class Solution {
    // construct bst from inorder traversal
    public static TreeNode constructFromInOrder(int[] inorder, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        TreeNode node = new TreeNode(inorder[mid]);

        node.left = constructFromInOrder(inorder, si, mid - 1);
        node.right = constructFromInOrder(inorder, mid + 1, ei);

        return node;
    }

    // construct bst from level order traversal
    public static class levelPair {
        TreeNode par = null;
        int lb = -(int) 1e8;
        int rb = (int) 1e8;

        levelPair(TreeNode par, int lb, int rb) {
            this.par = par;
            this.lb = lb;
            this.rb = rb;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] arr) {
        int idx = 0;
        LinkedList<levelPair> que = new LinkedList<>();
        TreeNode root = null;
        que.add(new levelPair(root, 0, 0)); // TODO

        while (que.size() != 0 && idx < arr.length) {
            levelPair pair = que.removeFirst();

            if (arr[idx] < pair.lb || arr[idx] > pair.rb)
                continue;

            TreeNode node = new TreeNode(arr[idx++]);
            if (pair.par == null)
                root = node;
            else {
                if (node.val < pair.par.val)
                    pair.par.left = node;
                else
                    pair.par.right = node;
            }

            que.addLast(new levelPair(node, pair.lb, node.val));
            que.addLast(new levelPair(node, node.val, pair.rb));
        }

        return root;
    }

    // construct bst from post order traversal
    public static TreeNode bstFromPostorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }

        idx = preorder.length - 1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return bstFromPostorder(preorder, min, max);
    }

    static int idx;

    public static TreeNode bstFromPostorder(int[] preorder, int min, int max) {

        if (idx < 0) {
            return null;
        }

        int val = preorder[idx];
        if (val < min || val > max) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        idx--;

        node.right = bstFromPostorder(preorder, val, max);
        node.left = bstFromPostorder(preorder, min, val);

        return node;
    }

    // construct bst from pre order traversal
    public static TreeNode bstFromPreorder() {
        return null;
    }
}
