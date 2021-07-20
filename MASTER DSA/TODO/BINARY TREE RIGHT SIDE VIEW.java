/**
Binary Tree Right Side View |  Medium | Adobe, Google, Amazon |

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you 
can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
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
                if(i == size){
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
