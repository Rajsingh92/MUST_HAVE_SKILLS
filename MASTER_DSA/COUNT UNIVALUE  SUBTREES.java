/**
Count Univalue Subtrees |  Medium | Amazon |

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example

Input:  root = {5,1,5,5,5,#,5}
Output: 4
Explanation:
              5
             / \
            1   5
           / \   \
          5   5   5
 */


class Solution {
    public String helper(TreeNode root, int count) {
        if (root == NULL) {
            return "";
        }

        String left = helper(root.left, count);
        String right = helper(root.right, count);
        String val = to_string(root.val);

        if ((left == "" || val == left) && (val == right || right == "")) {
            count++;
            return val;
        }

        return "#";
    }

    int countUnivalSubtrees(TreeNode root) {
        if (root == NULL)
            return 0;

        int count = 0;
        helper(root, count);
        return count;
    }
}
