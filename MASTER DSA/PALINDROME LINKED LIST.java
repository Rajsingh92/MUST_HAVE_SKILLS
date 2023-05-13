/**
Palindrome Linked List |  Easy | Amazon, Google |
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
 */


class Solution {
    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null)
            return true;
        
        
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
         boolean res = true;
        
         while(curr1!=null && curr2!=null){
             if(curr1.val!=curr2.val){
                 res = false;
                 break;
             }
             curr1 = curr1.next;
             curr2 = curr2.next;
         }
        
        nhead = reverseList(nhead);
        mid.next = nhead;
        
        return res;
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

