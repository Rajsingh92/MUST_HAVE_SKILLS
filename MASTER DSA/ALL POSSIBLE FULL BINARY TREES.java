/**
All Possible Full Binary Trees | Medium | Google |

Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each 
tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of 
trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Example 1:

Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 */
    


class Solution {
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new LinkedList();

        if (n % 2 == 0) {
            return ans;
        }

        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        for (int i = 0; i < n; i++) {

            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        map.put(n, ans);

        return map.get(n);
    }
}
