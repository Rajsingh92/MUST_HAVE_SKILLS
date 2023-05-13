class BST {
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

    public TreeNode insertIntoBST(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data > node.val) {
            node.right = insertIntoBST(node.right, data);
            // lchild.parent = node; -- if parent pointer avilable
            return node;
        } else if (data < node.val) {
            node.left = insertIntoBST(node.left, data);
            // rchild.parent = node;
            return node;
        } else {
            return node;
        }
    }

    public TreeNode deleteNode(TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.val) {
            node.right = deleteNode(node.right, data);
            return node;
        } else if (data < node.val) {
            node.left = deleteNode(node.left, data);
            return node;
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int max = max(node.left);
                node.val = max;
                node.left = deleteNode(node.left, max);
                return node;
            }
        }

    }

    public static int size(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    public static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.val;
        return ts;
    }

    public int max(TreeNode root) {
        if (root.right == null) {
            return root.val;
        }

        int res = max(root.right);
        return res;
    }

    public static int min(TreeNode root) {
        if (root.left == null) {
            return root.val;
        }

        int res = min(root.left);
        return res;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }

    }

    public TreeNode searchBST2(TreeNode root, int val) {

        TreeNode node = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == val) {
                node = curr;
                break;
            } else if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return node;
    }

    static int sum = 0;

    public static void rwsol(TreeNode node) {
        if (node == null) {
            return;
        }

        rwsol(node.right);

        int od = node.val;
        node.val = sum;
        sum += od;

        rwsol(node.left);
    }

    public static void pir(TreeNode node, int d1, int d2) {
        if (node == null) {
            return;
        }

        if (node.val > d1 && node.val > d2) {
            pir(node.left, d1, d2);
        } else if (node.val < d1 && node.val < d2) {
            pir(node.right, d1, d2);
        } else {
            pir(node.left, d1, d2);
            System.out.println(node.val);
            pir(node.right, d1, d2);
        }
    }

    public static void targetSumPair(TreeNode root, TreeNode node, int tar) {
        if (node == null) {
            return;
        }

        targetSumPair(root, node.left, tar);

        int comp = tar - node.val;
        if (comp > node.val) {
            if (find(root, comp)) {
                System.out.println(node.data + " " + comp);
            }
        }

        targetSumPair(root, node.right, tar);
    }

    

    public static void predSuccInBST(TreeNode node, int data) {

        TreeNode curr = node;
        TreeNode pred = null;
        TreeNode succ = null;
        boolean isDataPresent = false;

        while (curr != null) {

            if (curr.val == data) {
                isDataPresent = true;
                if (curr.left != null) {
                    pred = curr.left;
                    while (pred.right != null)
                        pred = pred.right;
                }

                if (curr.right != null) {
                    succ = curr.right;
                    while (succ.left != null)
                        succ = succ.left;
                }

                break;
            } else if (curr.val < data) {
                pred = curr;
                curr = curr.right;
            } else {
                succ = curr;
                curr = curr.left;
            }
        }
    }
}