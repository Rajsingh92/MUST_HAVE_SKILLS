def sortedInsert(stack,top):
    if not stack or top>stack[-1]:
        stack.append(top)
        return
    
    tmp = stack.pop()
    sortedInsert(stack,top)
    stack.append(tmp)
    

def sortStack(stack):
    if not stack:
        return
    
    top = stack.pop()
    sortStack(stack)
    sortedInsert(stack,top)



def insertAtBottom(stack,item):
    if not stack:
        stack.append(item)
        return
    
    tmp = stack.pop()
    insertAtBottom(stack,item)
    stack.append(tmp)



def reverseStack(stack):
    if not stack:
        return

    top = stack.pop()
    reverseStack(stack)
    insertAtBottom(top)




# reverse queue
def reverse(q):  #recursion
    if not q:
        return
    
    data = q.front()
    q.pop()
    reverse(q)
    q.enqueue(data)

def reverse2(q):  # stack

    stack = []
    while q:
        stack.append(q.popleft())
    while stack:
        q.append(stack.pop())

        