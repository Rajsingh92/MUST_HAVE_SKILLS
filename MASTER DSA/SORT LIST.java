/**
Sort List |  Medium | Amazon, Facebook, Google, Microsoft |
Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
 */


 // merge sort
class Solution {
    public ListNode sortList(ListNode head) {
       if(head == null){
           return null;
       } 
       if(head.next == null){
           return head;
       }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode start = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(start);
            
        return mergeList(left,right);
    
    
        
    }
    
    public ListNode mergeList(ListNode left,ListNode right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        ListNode res = new ListNode(); 
        ListNode dummy = res;
        
        while(left!=null && right!=null){
            if(left.val>right.val){
                res.next = right;
                res = res.next;
                right = right.next;
            }else{
                res.next = left;
                res = res.next;
                left = left.next;
            }
        }
        
        while(left!=null){
            res.next = left;
            res = res.next;
            left = left.next;
        }
        while(right!=null){
            res.next = right;
            res = res.next;
            right = right.next;
        }
        
        return dummy.next;
        
    }
}

// quick sort

class Solution {
    public ListNode sortList(ListNode head) {
        return quickSort_(head)[0];
    }

    public static int length(ListNode node) {
        if (node == null)
            return 0;

        ListNode curr = node;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }

    public static ListNode[] segregate(ListNode head, int pivotIdx) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode pivotNode = head, sp = small, lp = large, curr = head;
        while (pivotIdx-- > 0)
            pivotNode = pivotNode.next;

        while (curr != null) {
            if (curr != pivotNode) {
                if (curr.val <= pivotNode.val) {
                    sp.next = curr;
                    sp = sp.next;
                } else {
                    lp.next = curr;
                    lp = lp.next;
                }
            }

            curr = curr.next;
        }

        pivotNode.next = null;
        sp.next = null;
        lp.next = null;

        return new ListNode[] { small.next, pivotNode, large.next };
    }

    public static ListNode[] mergeElements(ListNode[] left, ListNode pivotNode, ListNode[] right) {
        ListNode head = null;
        ListNode tail = null;
        if (left[0] != null && right[0] != null) {
            head = left[0];
            tail = right[1];
            left[1].next = pivotNode;
            pivotNode.next = right[0];
        } else if (left[0] != null) {
            head = left[0];
            tail = pivotNode;
            left[1].next = pivotNode;
        } else if (right[0] != null) {
            head = pivotNode;
            tail = right[1];
            pivotNode.next = right[0];
        } else {
            head = tail = pivotNode;
        }

        return new ListNode[] { head, tail };
    }

    public static ListNode[] quickSort_(ListNode head) {
        if (head == null || head.next == null)
            return new ListNode[] { head, head };

        int len = length(head);
        int pivotIdx = len / 2;
        ListNode[] segregatedElements = segregate(head, pivotIdx);

        ListNode[] left = quickSort_(segregatedElements[0]);
        ListNode[] right = quickSort_(segregatedElements[2]);

        return mergeElements(left, segregatedElements[1], right);
    }
}