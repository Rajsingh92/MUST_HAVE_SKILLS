/**
Binary Tree Cameras |  Hard | Google |

Given a binary tree, we install cameras on the nodes of the tree. 
Each camera at a node can monitor its parent, itself, and its immediate children.
Calculate the minimum number of cameras needed to monitor all nodes of the tree.


Example 1:


Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
 */



class Solution {
    int camera = 0;

    public int minCameraCover_(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int lres = minCameraCover_(root.left);
        int rres = minCameraCover_(root.right);

        if (lres == -1 || rres == -1) {
            camera++;
            return 0;
        }

        if (lres == 0 || rres == 0) {
            return 1;
        }

        return -1;
    }

    public int minCameraCover(TreeNode root) {
        if (minCameraCover_(root) == -1)
            camera++;
        return camera;
    }
}