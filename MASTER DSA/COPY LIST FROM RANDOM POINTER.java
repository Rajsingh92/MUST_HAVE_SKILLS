/**
Copy List with Random Pointer |  Medium | Alibaba, Facebook |
A linked list is given such that each node contains an additional random pointer which could point to any node in 
the list or null.
Return a deep copy of the list.
The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of 
[val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */

public class Solution {



	public Node copyRandomList(Node head) {
        //First: we try to make new nodes and link them next to each other.
        Node curr=head,forw=null;
        while(curr!=null){
            forw=curr.next;

            Node copyNode=new Node(curr.val);
            curr.next=copyNode;
            copyNode.next=forw;

            curr=forw;
        }

        //second: set random pointers.
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random=curr.random.next;  
            curr=curr.next.next;
        }

        //Third: extract copy List.
        curr=head;
        Node newList=new Node(-1);  // dummy Node.
        Node newCurr=newList;
        Node copyNode=null;

        while(curr!=null){
            forw=curr.next.next;

            copyNode=curr.next;
            newCurr.next=copyNode;
            curr.next=forw;

            curr=forw;
            newCurr=copyNode;
        }

        return newList.next;
    }

}


