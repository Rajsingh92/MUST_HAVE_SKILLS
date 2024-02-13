/**
Split a Circular Linked List into two halves 

Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes 
in the given circular linked list then out of the resulting two halved lists, first list should have one node 
more than the second list. The resultant lists should also be circular lists and not linear lists.

 
Example :

Input:
Circular LinkedList: 2->6->1->5

Output:
2 6
1 5
 */

public class Solution{
    static Node head, head1, head2; 

    public static void splitList(){
        if(head == null){
            return;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next!=head && fast.next.next!=head){
            slow = slow.next;
            fast = fast.next.next;
        }

        //even elements
        if(fast.next.next == head){
            fast = fast.next;
        }

        head1 = head;
        if(head.next != head){
            head2 = slow.next;
        }

        fast.next = slow.next;
        slow.next = head;
    }
}


