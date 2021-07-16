/**
Left View of Binary Tree 
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from 
Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8 
 */

class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size()!=0){
            
            int size = queue.size();
            int i = 0;
            
            while(i<size){
                i++;
                TreeNode node = queue.removeFirst();
                if(i == 1){
                    res.add(node.val);
                }
                
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if(node.right!=null){
                    queue.addLast(node.right);
                }
                
            }
            
            
        }
        
        return res;
    }
}