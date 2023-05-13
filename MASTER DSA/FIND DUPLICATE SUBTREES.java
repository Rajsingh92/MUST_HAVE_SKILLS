/**
Find Duplicate Subtrees | Medium | Amazon Bloomberg Google Lyft Microsoft Oracle Uber |

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
 */


class Solution {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> ans=new ArrayList<>();
		serialize(root,new HashMap<>(),ans);
		return ans;
	}
	private String serialize(TreeNode root,Map<String,Integer> map,List<TreeNode> ans){
		if(root==null)  return " "; 
        
		
        String left = serialize(root.left, map, ans);
        String right = serialize(root.right, map, ans);
        String curr = root.val +"," + left + "," + right;
    
        
		int freq = map.getOrDefault(curr,0);
		if(freq == 1)  
            ans.add(root);
            
		map.put(curr,freq+1);
		return curr;
	}    
}
