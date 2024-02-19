/**
Range Sum of BST  | Google |

Given the root node of a binary search tree, return the sum of values of all nodes with a value in the 
range [low, high].


Example 1:

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
 */



class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        if (root.data >= low && root.data <= high) {
            return root.data + left + right;
        } else if (root.data > high) {
            return left;
        } else {
            return right;
        }
    }

}