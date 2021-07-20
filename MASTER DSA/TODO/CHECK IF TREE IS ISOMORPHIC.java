/**
Check if Tree is Isomorphic 

Given two Binary Trees. Check whether they are Isomorphic or not.

Note: 
Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping 
left and right children of several nodes. Any number of nodes at any level can have their children swapped. 
Two empty trees are isomorphic.

Example 1:

Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes
 */


class Solution {

    boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
                || (isIsomorphic(root1.left, root2.right) && (isIsomorphic(root1.right, root2.left)));
    }
}



