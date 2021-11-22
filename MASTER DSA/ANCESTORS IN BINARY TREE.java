/**
Ancestors in Binary Tree 

Given a Binary Tree and a target key, you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1
 */

class Solution {

    public static ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        getAncestors(root, target, res);
        return res;
    }

    public static boolean getAncestors(Node root, int target, ArrayList<Integer> res) {
        if (root == null)
            return false;

        if (root.data == target) {
            return true;
        }

        boolean left = getAncestors(root.left, target, res);
        boolean right = getAncestors(root.right, target, res);
        if (left || right) {
            res.add(root.data);
            return true;
        }

        return false;
    }
}