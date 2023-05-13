/**
Print Nodes having K leaves 
Given a binary tree and a integer value K, the task is to find all nodes data in given binary tree having 
exactly K leaves in sub-tree rooted with them.

NOTE: Nodes should be printed in the order in which they appear in postorder traversal.

Example 1:

Input:
K = 1
      0
    /   \
   1     2
Output: -1
Explanation: There is no node in this
tree which has one leaf in the sub tree
below it.
 */

class Solution {
    public ArrayList<Integer> btWithKleaves(Node root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        btWithKleaves(root, k, res);

        if (res.size() > 0) {
            return res;
        } else {
            res.add(-1);
            return res;
        }
    }

    public int btWithKleaves(Node root, int k, ArrayList<Integer> res) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = btWithKleaves(root.left, k, res);
        int right = btWithKleaves(root.right, k, res);

        if (left + right == k) {
            res.add(root.data);
        }

        return left + right;
    }
}