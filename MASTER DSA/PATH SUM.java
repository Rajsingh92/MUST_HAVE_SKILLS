/**
Path Sum  | Amazon |

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
 */

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum_rec(root, targetSum, 0);
    }

    public boolean hasPathSum_rec(TreeNode root, int data, int ssf) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            int res = ssf + root.val;

            if (res == data)
                return true;
        }

        return hasPathSum_rec(root.left, data, ssf + root.val) || hasPathSum_rec(root.right, data, ssf + root.val);

    }
}


/**
Path Sum II |  Medium | Amazon, appdynamics, Facebook, Google |

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
 */


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        findPaths(root, targetSum, res, new ArrayList<Integer>());
        return res;
    }

    public void findPaths(TreeNode root, int targetSum, List<List<Integer>> res, ArrayList<Integer> curr) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.val - targetSum == 0) {
                ArrayList<Integer> base = new ArrayList<>(curr);
                base.add(root.val);
                res.add(base);
            }
            return;
        }

        curr.add(root.val);
        findPaths(root.left, targetSum - root.val, res, curr);
        findPaths(root.right, targetSum - root.val, res, curr);
        curr.remove(curr.size() - 1);
    }
}






/*

| 437 | Path Sum III |  Easy | Amazon, Facebook |

// 113
    public void pathSum(TreeNode root, int tar, List<List<Integer>> res, List<Integer> smallAns) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (tar - root.val == 0) {
                ArrayList<Integer> base = new ArrayList<>(smallAns);
                base.add(root.val);
                res.add(base);
            }

            return;
        }

        smallAns.add(root.val);

        pathSum(root.left, tar - root.val, res, smallAns);
        // print("hello");
        pathSum(root.right, tar - root.val, res, smallAns);

        smallAns.remove(smallAns.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, res, new ArrayList<>());
        return res;

    }
 */