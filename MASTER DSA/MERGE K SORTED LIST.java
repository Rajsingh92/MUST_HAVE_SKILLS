/**
Merge k Sorted Lists |  Hard | Adobe, Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.


Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */


class Solution {
    //O(NKlog(N))
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }  
        return mergeKList(lists,0,lists.length-1);
        
    }
    
    public ListNode mergeKList(ListNode[] lists,int li,int ri){
        if (li == ri)
            return lists[li];

        int mid = (li + ri) / 2;

        ListNode l1 = mergeKList(lists, li, mid);
        ListNode l2 = mergeKList(lists, mid + 1, ri);
        ListNode finalList = mergeTwoLists(l1, l2);

        return finalList;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode head = new ListNode(-1); // dummy Node.
        ListNode prev = head;

        ListNode c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                prev = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev = c2;
                c2 = c2.next;
            }
        }

        if (c2 != null)
            prev.next = c2;
        else
            prev.next = c1;

        return head.next;
    }
}

//priority queue 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}