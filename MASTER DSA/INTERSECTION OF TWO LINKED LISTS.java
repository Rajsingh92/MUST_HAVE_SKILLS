/**
Intersection of Two Linked Lists |  Easy | Amazon |

Write a program to find the node at which the intersection of two singly linked lists begins.
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes 
 before the intersected node in A; There are 3 nodes before the intersected node in B.
 */


public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        
        if(fast!=slow){
            return null;
        }
        
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode curr = headA;
        while(curr.next!=null){
            curr = curr.next;
        }
        
        curr.next = headB;  // create cycle
        ListNode ans = detectCycle(headA);
        curr.next = null;
        return ans;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        ListNode currA = headA;
        ListNode currB = headB;
        
        int delta = Math.abs(sizeA - sizeB);
        
        if(sizeA>sizeB){
            for(int i = 0; i<delta;i++){
                currA = currA.next;
            }
        }else{
            for(int i = 0; i<delta;i++){
                currB = currB.next;
            }
        }
        
        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }
        
        return currA;
    }
    
    public int getSize(ListNode head){
        int size = 0;
        ListNode curr = head;
        
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        return size;
    }
}

