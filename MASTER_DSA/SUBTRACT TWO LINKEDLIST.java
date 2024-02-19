/**
Subtract Two Linkedlist

You are give two single linkedlist of digits The most significant digit comes first and each of their nodes contain 
a single digit. Subtract the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself

Input Format
1->2->3->4->5->6->7->null
7->8->9->null

Output Format
1->2->3->3->7->7->8->null
 */


class Solution {
    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            l2.val = -l2.val;
            return l2;
        }

        int borrow = 0;
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        ListNode nh = new ListNode(-1);
        ListNode itr = nh;

        while (c1 != null || c2 != null) {
            int diff = borrow + (c1.val) - (c2 != null ? c2.val : 0);

            if (diff < 0) {
                diff += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            itr.next = new ListNode(diff);
            itr = itr.next;

            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        return reverse(nh.next);
    }
}