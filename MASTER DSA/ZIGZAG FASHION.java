/**
Rearrange a Linked List in Zig-Zag fashion
Given a linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f .. 
where a, b, c.. are consecutive data node of the linked list.

Examples:

Input:  1->2->3->4
Output: 1->3->2->4 

Input:  11->15->20->5->10
Output: 11->20->5->15->10
 */

class Solution {
    public static Node zigZag(Node head) {
        boolean flag = true;

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (flag) {
                if (curr.data > curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            } else {
                if (curr.data < curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            flag = !flag;
            curr = curr.next;
        }

        return head;
    }
}