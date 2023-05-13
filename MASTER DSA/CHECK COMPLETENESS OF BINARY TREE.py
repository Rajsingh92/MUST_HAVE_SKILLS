'''
Check Completeness of a Binary Tree |  Medium | Facebook, Microsoft |
Given the root of a binary tree, determine if it is a complete binary tree.
In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last 
level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


Example 1:
Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the 
last level ({4, 5, 6}) are as far left as possible.
'''
import collections
class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        
        queue = collections.deque()
        queue.append((root,1))
        res = []
        
        while queue:
            node,nodeNo = queue.popleft()
            res.append(nodeNo)
            
            if node.left:
                queue.append((node.left,nodeNo*2))
            if node.right:
                queue.append((node.right,nodeNo*2+1))
                
        return len(res) == res[-1]

        