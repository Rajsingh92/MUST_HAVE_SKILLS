/**
Delete Alternate Nodes 

Given a Singly Linked List of size N, delete all alternate nodes of the list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 1->3->5
Explanation: Deleting alternate nodes
results in the linked list with elements
1->3->5.
 */


class Solution {

    public void deleteAlternate(Node head) {

        Node prev = head;
        Node curr = head.next;

        while (prev != null && curr != null) {
            prev.next = curr.next;
            curr.next = null;
            prev = prev.next;
            if (prev != null) {
                curr = prev.next;
            }
        }
    }
}