// Count BST ndoes that lie in a given range
class Tree {
    int getCount(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }

        int left = getCount(root.left, l, h);
        int right = getCount(root.right, l, h);

        if (root.data >= l && root.data <= h) {
            return 1 + left + right;
        } else if (root.data < l) {
            return right;
        } else {
            return left;
        }

    }
}
