/*
Delete nodes having greater value on right 
Given a singly linked list, remove all the nodes which have a greater value on its following nodes.

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are the elements which have greater elements on their next node. So, after deleting
them, the linked list would like be 15,11, 6, 3.
*/

public class Solution{
    
    public static void deleteRightNode(Node head){
        int max = head.data;
		Node node = head.next;
		Node prev = head;
		while (node != null) {
			if (node.data > max) {
				max = node.data;
				prev = node;
			} else {
				prev.next = node.next;
			}

			node = node.next;
		}
    }


    public static void deletenodes(Node head){
        reverse(head);
        deleteRightNode(head);
        reverse(head);
    }

    public static void reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}