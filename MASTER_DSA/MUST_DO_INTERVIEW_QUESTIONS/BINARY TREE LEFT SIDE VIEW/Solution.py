from collections import deque


def LeftView(root):
    if root is None:
        return []
        
    queue = deque()
    queue.append(root)
    ans = []
    
    while queue:
        size = len(queue)
        flag = True
        
        while size :
            rem = queue.popleft()
            if flag:
                ans.append(rem.data)
                flag = False
            
            if rem.left:
                queue.append(rem.left)
            if rem.right:
                queue.append(rem.right)
                
            size -= 1
            
            
            
    return ans

    