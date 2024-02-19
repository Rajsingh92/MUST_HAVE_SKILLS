/**
Clone a Binary Tree 

Given a special binary tree having random pointers along with the usual left and right pointers. 
Clone the given tree.

Example 1:

Input:

Output: 1
Explanation: The tree was cloned successfully.
 */

class Solution {
    public static Tree cloneLeftRightPointer(Tree root, HashMap<Tree, Tree> map) {
        if (root == null)
            return null;

        map.put(root, new Tree(root.data));
        map.get(root).left = cloneLeftRightPointer(root.left, map);
        map.get(root).right = cloneLeftRightPointer(root.right, map);

        return map.get(root);
    }

    public static void updateRandomPointer(Tree root, HashMap<Tree, Tree> map) {
        if (root == null)
            return;

        map.get(root).random = root.random;
        updateRandomPointer(root.left, map);
        updateRandomPointer(root.right, map);
    }

    public static Tree cloneTree(Tree root) {
        HashMap<Tree, Tree> map = new HashMap<>();
        cloneLeftRightPointer(root, map);
        updateRandomPointer(root, map);
        return map.get(root);
    }
}

