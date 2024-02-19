/**
Leaf at same level 

Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input: 
            1
          /   \
         2     3

Output: 1

Explanation: 
Leaves 2 and 3 are at same level.
 */

 
class Solution {
    boolean check(Node root) {
        if (root == null)
            return true;

        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        int result = Integer.MAX_VALUE;
        int level = 0;

        while (q.size() != 0) {
            int size = q.size();
            level++;

            while (size-- > 0) {
                Node temp = q.remove();

                if (temp.left != null) {
                    q.add(temp.left);

                    if (temp.left.left == null && temp.left.right == null) {
                        if (result == Integer.MAX_VALUE)
                            result = level;
                        else if (result != level)
                            return false;
                    }
                }

                if (temp.right != null) {
                    q.add(temp.right);

                    if (temp.right.left == null && temp.right.right == null) {
                        if (result == Integer.MAX_VALUE)
                            result = level;
                        else if (result != level)
                            return false;
                    }
                }
            }

        }
        return true;
    }
}