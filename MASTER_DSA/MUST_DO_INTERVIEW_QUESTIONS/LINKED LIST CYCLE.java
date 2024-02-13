/**
Linked List Cycle |  Easy | Adobe, Akuna Capital, Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously 
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer 
is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.


Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;  // length of loop
        
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
            if(slow == fast){
                return true;
            }
        }
        return false;
        
    }
}

/**
Linked List Cycle II |  Medium | Apple, Google, Microsoft |
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously 
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer 
is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        
        if(fast!=slow){
            return null;
        }
        
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;  // to remove loop fast.next = null
    }
}

