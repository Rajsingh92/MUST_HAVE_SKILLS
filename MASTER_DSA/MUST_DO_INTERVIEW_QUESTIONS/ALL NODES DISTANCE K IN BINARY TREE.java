/**
All Nodes Distance K in Binary Tree |  Medium | Amazon, Google, Microsoft |

We are given a binary tree (with root node root), a target node, and an integer value k.

Return a list of the values of all nodes that have a distance k from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2

Output: [7,4,1]
 */



class Solution {

    public void printKLevelsDown(TreeNode node, int k, TreeNode blocker, List<Integer> ans) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }

        if (k == 0) {
            ans.add(node.val);
            return;
        }

        printKLevelsDown(node.left, k - 1, blocker, ans);
        printKLevelsDown(node.right, k - 1, blocker, ans);
    }

    public ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {

        if (node == null) {
            return new ArrayList<>();
        }

        if (node.val == data) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            temp.add(node);
            return temp;
        }

        ArrayList<TreeNode> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node);
            return llist;
        }

        ArrayList<TreeNode> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node);
            return rlist;
        }

        return new ArrayList<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> path = nodeToRootPath(root, target.val);

        for (int i = 0; i < path.size() && i <= K; i++) {
            printKLevelsDown(path.get(i), K - i, i == 0 ? null : path.get(i - 1), ans);
        }

        return ans;
    }
}