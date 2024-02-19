class BinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ls = size(root.left);
        int rs = size(root.right);
        return ls + rs + 1;
    }

    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.val;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        int ts = Math.min(left, right);
        return ts + 1;
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int ts = Math.max(left, right);
        return ts + 1;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static boolean find(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (root.val == data) {
            return true;
        }

        boolean filc = find(root.left, data);
        if (filc) {
            return true;
        }

        boolean firc = find(root.right, data);
        if (firc) {
            return true;
        }

        return false;
    }

    public static class allSolPair {
        TreeNode prev = null;
        TreeNode pred = null;
        TreeNode succ = null;

        int ceil = (int) 1e8;
        int floor = -(int) 1e8;
    }

    public static void allSolution(TreeNode node, int data, allSolPair pair) {
        if (node == null)
            return;

        if (node.val < data)
            pair.floor = Math.max(pair.floor, node.val);

        if (node.val > data)
            pair.ceil = Math.min(pair.ceil, node.val);

        allSolution(node.left, data, pair);

        if (node.val == data && pair.pred == null)
            pair.pred = pair.prev;
        if (pair.prev != null && pair.prev.val == data && pair.succ == null)
            pair.succ = node;

        pair.prev = node;

        allSolution(node.right, data, pair);
    }

    public static void pathToLeafFromRoot(TreeNode node, String path, int sum, int lo, int hi) {
        if (node.left != null && node.right != null) {
            pathToLeafFromRoot(node.left, path + node.val + " ", sum + node.val, lo, hi);
            pathToLeafFromRoot(node.right, path + node.val + " ", sum + node.val, lo, hi);
        } else if (node.left != null) {
            pathToLeafFromRoot(node.left, path + node.val + " ", sum + node.val, lo, hi);
        } else if (node.right != null) {
            pathToLeafFromRoot(node.right, path + node.val + " ", sum + node.val, lo, hi);
        } else {
            path += node.val;
            sum += node.val;

            if (sum >= lo && sum <= hi) {
                System.out.println(path);
            }
        }
    }
}
