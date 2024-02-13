/**
Leaves to DLL 

Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List strating from the 
left most leaf. Modify the original tree to make the DLL thus removing the leaf nodes from the tree. 
Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.

Example 1:

Input :
        1
      /   \
     2     3
    / \   / \
   4   5 6   7    

Output: 
Modified Tree :
        1
      /   \
     2     3

Doubly Link List :
4 <-> 5 <-> 6 <-> 7
 */

public class Solution {

    public Node convertToDLL(Node root) {
        extractLeaves(root);
        return head;
    }

    Node head;
    Node prev;

    public Node extractLeaves(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (head == null) {
                head = root;
                prev = root;
            } else {
                prev.right = root;
                root.left = prev;
                prev = root;
            }

            return null;
        }

        root.left = extractLeaves(root.left);
        root.right = extractLeaves(root.right);

        return root;
    }
}
