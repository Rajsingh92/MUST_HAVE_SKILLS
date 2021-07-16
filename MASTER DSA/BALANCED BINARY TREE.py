'''
Balanced Binary Tree |  Easy | Amazon, Google |
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true
'''
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        if root.left is None and root.right is None:
            return True
        
        if abs(self.height(root.left)-self.height(root.right))<2 and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        
    def height(self,root):
        if root is None:
            return 0
        
        return 1+max(self.height(root.left),self.height(root.right))

# O(n)
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.height(root)!=-1
    
    def height(self,root):
        if root is None:
            return 0
        
        left = self.height(root.left)
        right = self.height(root.right)
        
        if left==-1 or right==-1 or abs(left-right)>1:
            return -1
        
        return 1+max(left,right)


