
// | 298 | Binary Tree Longest Consecutive Sequence | Medium | Amazon Facebook Google Uber |
class Binary_Tree_Longest_Consecutive_Sequence {

    public class Solution {

        private int maxLen = 0;

        public int longestConsecutive(TreeNode root) {
            longestConsecutive(root, 0, 0);
            return maxLen;
        }

        private void longestConsecutive(TreeNode root, int lastVal, int curLen) {
            if (root == null) {
                return;
            }
            if (root.val != lastVal + 1) {
                curLen = 1;
            } else {
                curLen++;
            }

            maxLen = Math.max(maxLen, curLen);

            longestConsecutive(root.left, root.val, curLen);
            longestConsecutive(root.right, root.val, curLen);
        }
    }

}


// | 549 | Binary Tree Longest Consecutive Sequence II | Medium | Amazon Apple Facebook Google |
class Binary_Tree_Longest_Consecutive_Sequence_II {

    class Solution {
        public int longestConsecutive(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int res = helper(root, 1) + helper(root, -1) + 1; // +1 is increasing, -1 is decreasing
            return Math.max(res, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
        }

        int helper(TreeNode node, int diff) {
            if (node == null) {
                return 0;
            }

            int left = 0, right = 0;
            if (node.left != null && node.val - node.left.val == diff) {
                left = 1 + helper(node.left, diff);
            }
            if (node.right != null && node.val - node.right.val == diff) {
                right = 1 + helper(node.right, diff);
            }

            return Math.max(left, right);
        }
    }
}
