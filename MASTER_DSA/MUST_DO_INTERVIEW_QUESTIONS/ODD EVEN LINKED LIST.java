/**
Odd Even Linked List |  Medium | Amazon, Google, Microsoft |
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are 
talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
*/

// unfold
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode ehead = even;
        
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        odd.next = ehead;
        return head;
    }
    
}
