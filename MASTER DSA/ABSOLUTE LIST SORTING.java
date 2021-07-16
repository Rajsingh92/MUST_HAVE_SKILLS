/**
Absolute List Sorting 
Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data. Sort the 
linked list according to the actual values.
Ex: Input : 1 -> -2 -> -3 -> 4 -> -5 
    Output: -5 -> -3 -> -2 -> 1 -> 4
*/

class Solution
{
	Node sortedList(Node head)
	{
		Node prev = head;
		Node curr = head;
		Node currHead = head;
		
		while(curr!=null){
		    if(curr.data<0){
		        //first node
		        if(prev == head && curr == head){
		            curr = curr.next;
		            continue;
		        }else{
		            prev.next = curr.next;
		            curr.next = currHead;
		            currHead = curr;
		            curr = prev.next;
		        }
		    }else{
		        prev = curr;
		        curr = curr.next;
		    }
		}
		head = currHead;
		return head;
	}
}