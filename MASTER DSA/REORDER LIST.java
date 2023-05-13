/**
Reorder List |  Medium | Amazon, Facebook, Google, Microsoft |
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */


class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
         ListNode mid = slow;
         System.out.println(mid.val);
        
         ListNode nhead = mid.next;
         mid.next = null;
        
         nhead = reverseList(nhead);
        
         ListNode curr1 = head;
         ListNode curr2 = nhead;
        
         while(curr1!=null && curr2!=null){
             ListNode f1 = curr1.next;  //backup
             ListNode f2 = curr2.next;
             
             curr1.next = curr2;
             curr2.next = f1;
             
             curr1 = f1;
             curr2 = f2;
         }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;  //backup
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        return head;
    }
}