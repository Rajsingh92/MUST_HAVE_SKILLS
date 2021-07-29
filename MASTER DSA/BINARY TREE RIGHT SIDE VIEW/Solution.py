class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        queue = deque()
        queue.append(root)
        ans = []
        
        while queue :
            size = len(queue)
            
            while size > 0:
                rem = queue.popleft()
                
                if size == 1:
                    ans.append(rem.val)
                    
                if rem.left:
                    queue.append(rem.left)
                if rem.right:
                    queue.append(rem.right)
                    
                size -= 1
                
        return ans
    
    