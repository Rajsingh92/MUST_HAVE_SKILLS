/**
Merge Two Sorted Lists |  Easy | Airbnb, Alibaba |
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the 
nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */

public class Solution{
    public static Node mergeTwoLists(Node first,Node second){
        if(first == null){
            return second;
        }

        if(second == null){
            return first;
        }
        Node res = null;
        if(first.data>second.data){
            res = second;
            res.next = mergeTwoLists(first, second.next);
        }else{
            res = first;
            res.next = mergeTwoLists(first.next, second);
        }

        return res;
    }

    public static Node mergeTwoLists2(Node first,Node second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        Node curr1 = first;
        Node curr2 = second;

        while(curr1!=null && curr2!=null){
            if(curr1.data>curr2.data){
                tail.next = curr2;
                tail = tail.next;
                curr2 = curr2.next;
            }else{
                tail.next = curr1;
                tail = tail.next;
                curr1 = curr1.next;
            }
        }

        if(curr1!=null){
            tail.next = curr1;
        }
        if(curr2!=null){
            tail.next = curr2;
        }

        return dummy.next;
    }
}
