/**
Binary Tree Level Order Traversal | Apple, Google |

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
 */


public class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (queue.size() != 0) {

            int size = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            while (size-- > 0) {
                TreeNode rnode = queue.removeFirst();
                if (rnode.left != null) {
                    queue.addLast(rnode.left);
                }
                if (rnode.right != null) {
                    queue.addLast(rnode.right);
                }

                subList.add(rnode.val);
            }

            res.add(subList);
        }

        return res;
    }
}
