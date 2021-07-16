/**
Populate Inorder Successor for all nodes 

Given a Binary Tree, write a function to populate next pointer for all nodes. The next 
pointer for every node should be set to point to inorder successor.

Example 1:

Input:
        10
       /  \
      8    12
     /
    3

Output: 3->8 8->10 10->12 12->-1
 */


class Solution {
    Node next = null;

    public void populateNext(Node root) {
        if (root == null)
            return;

        populateNext(root.right);
        root.next = next;
        next = root;
        populateNext(root.left);
    }
}
