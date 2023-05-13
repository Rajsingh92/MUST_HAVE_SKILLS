/**
Remove duplicates from an unsorted linked list 
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value 
appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.

Example 1:

Input:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4
Explanation:Given linked list elements are
5->2->2->4, in which 2 is repeated only.
So, we will delete the extra repeated
elements 2 from the linked list and the
resultant linked list will contain 5->2->4
 */

class Solution
{
    public Node removeDuplicates(Node head) 
    {
         HashSet<Integer> hs = new HashSet<>();
         
         Node curr = head;
         Node prev = null;
         
         while(curr!=null){
             if(hs.contains(curr.data)){
                 prev.next = curr.next;
             }else{
                 hs.add(curr.data);
                 prev = curr;
             }
             curr = curr.next;
         }
         
         
         return head;
         
    }
}



