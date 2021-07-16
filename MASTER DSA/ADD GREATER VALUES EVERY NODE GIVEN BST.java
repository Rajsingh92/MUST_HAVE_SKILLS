/**
Add all greater values to every node in a BST 

Given a BST, modify it so that all greater values in the given BST are added to every node.

Example 1:

Input:
           50
         /    \
        30    70
      /   \   / \  
     20   40 60  80
Output: 350 330 300 260 210 150 80
Explanation:The tree should be modified to
following:
             260
          /       \
        330      150
       /   \   /     \
    350   300 210    80
 */


class Solution{
    
    static int sum ;
    public Node modify(Node root)
    {  
        sum = 0;
        modifyBST(root);
        return root;
    }
    
    public void modifyBST(Node node) {
        
        if (node == null)
            return;


        modifyBST(node.right);
        
        sum = sum + node.data;
        node.data = sum;

        modifyBST(node.left);
    }

}