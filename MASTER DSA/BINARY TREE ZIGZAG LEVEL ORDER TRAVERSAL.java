/**
Binary Tree Zigzag Level Order Traversal |  Medium | Adobe, Google |
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to 
left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 */


class Solution {
    public static class Pair{
        TreeNode node;
        int level;
        
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root,1));
        
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            
            while(size-->0){
                Pair rem = queue.removeFirst();
                if(rem.level%2 == 0){
                    sublist.add(0,rem.node.val);
                }else{
                    sublist.add(rem.node.val);
                }
                
                if(rem.node.left!=null){
                    queue.addLast(new Pair(rem.node.left,rem.level+1));
                }
                
                if(rem.node.right!=null){
                    queue.addLast(new Pair(rem.node.right,rem.level+1));
                }
            }
            
            res.add(sublist);
        }
        
        return res;
        
    }
}