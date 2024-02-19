'''
Move last element to front of a given Linked List
Write a function that moves the last element to the front in a given Singly Linked List. For example, if the given Linked 
List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.

'''

class Solution:
    def moveLastToFront(self, head: ListNode, k: int) -> ListNode:
        if head is None or head.next is None:
            return head
        
        secondLast = head
        while secondLast.next.next:
            secondLast = secondLast.next
        
        secondLast.next.next = head
        head = secondLast.next
        secondLast.next = None
        
        return head
        

# addFirst method can also be used 
