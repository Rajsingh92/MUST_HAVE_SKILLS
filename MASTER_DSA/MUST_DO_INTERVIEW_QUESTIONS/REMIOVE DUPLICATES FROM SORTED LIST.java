/**
Remove Duplicates from Sorted List |  Easy | Apple, Google |
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        
        return head;
    }
}

        
    
/**
Remove Duplicates from Sorted List II |  Medium | Google |
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummyNode = pre = ListNode(0)
        dummyNode.next = head
        
        while head and head.next:
            if head.val == head.next.val:
                while head and head.next and head.val == head.next.val :
                    head = head.next
                head = head.next
                pre.next = head
                
            else:
                pre = pre.next
                head = head.next
                
                
        return dummyNode.next
 */

