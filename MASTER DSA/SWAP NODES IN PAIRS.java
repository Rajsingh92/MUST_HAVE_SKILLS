/**
Swap Nodes in Pairs |  Medium | Adobe, Amazon, Google |
Given a linked list, swap every two adjacent nodes and return its head.

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
 */


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head, prev = null;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;

            if (prev == null) {
                head = temp;
            } else {
                prev.next = temp;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}


