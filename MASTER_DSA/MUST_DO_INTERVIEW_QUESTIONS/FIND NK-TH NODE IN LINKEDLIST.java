/**
Find n/k th node in Linked list 

Given a singly linked list and a number k. Write a function to find the (N/k)th element, where N is the number of elements 
in the list. We need to consider ceil value in case of decimals.
 */

class Solution {
    public static int nknode(Node head, int k) {

        Node curr = head;
        Node slow = head;

        int count = 0;
        while (curr != null) {
            if (count != 0 && count % k == 0) {
                slow = slow.next;
            }

            count++;
            curr = curr.next;
        }

        return slow.data;

    }
}


