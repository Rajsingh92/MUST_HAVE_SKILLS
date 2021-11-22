/**
Check If Circular Linked List 
Given a singly linked list, find if the linked list is circular or not. A linked list is called circular if it not 
NULL terminated and all nodes are connected in the form of a cycle. An empty linked list is considered as circular.

Example 1:

Input:
LinkedList: 1->2->3->4->5
(the first and last node is connected,
i.e. 5 --> 1)
Output: 1
 */


class GfG
{
    boolean isCircular(Node head)
    {
        
        if(head==null){
            return true;
        }
        
	    Node start = head;
	    Node end = head.next;
	    
	    while(end!=null){
	        if(start == end){
	            return true;
	        }
	        end = end.next;
	    }
	    
	    return false;
    }
}