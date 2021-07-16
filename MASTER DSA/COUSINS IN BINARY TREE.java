/**
Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
 */


class Solution {
    public class Pair {
        TreeNode node;
        TreeNode parent;
        int level;

        public Pair(TreeNode node, TreeNode parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        LinkedList<Pair> queue = new LinkedList<>();
        Pair np = new Pair(root, null, 0);
        queue.add(np);

        TreeNode xParent = null;
        TreeNode yParent = null;
        int xLevel = 0;
        int yLevel = 0;

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                if (rem.node.val == x) {
                    xLevel = rem.level;
                    xParent = rem.parent;
                }

                if (rem.node.val == y) {
                    yLevel = rem.level;
                    yParent = rem.parent;
                }

                if (rem.node.left != null) {
                    Pair cp = new Pair(rem.node.left, rem.node, rem.level + 1);
                    queue.add(cp);
                }

                if (rem.node.right != null) {
                    Pair cp = new Pair(rem.node.right, rem.node, rem.level + 1);
                    queue.add(cp);
                }
            }
        }

        if (xLevel == yLevel) {
            if (xParent.val != yParent.val) {
                return true;
            }
        }

        return false;
    }
}