from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        
        queue = deque()
        queue.append(root)
        ans = []
        
        while queue:
            size = len(queue)
            temp = []
            
            while size:
                rem = queue.popleft()
                temp.append(rem.val)
                
                if rem.left:
                    queue.append(rem.left)
                if rem.right:
                    queue.append(rem.right)
                
                size -= 1
            
            ans.append(temp)
                
        return ans

        