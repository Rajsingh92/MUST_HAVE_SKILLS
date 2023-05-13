/**
Reverse Linked List |  Easy | Adobe, Alibaba, Facebook, Google, Microsoft |

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 */



class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // backup
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode nextNode = head.next;
        head.next = null;
        ListNode rl = reverseListRec(nextNode);
        nextNode.next = head;

        return rl;
    }

    // reverse using addFirst
    ListNode th = null;
    ListNode tt = null;
    public ListNode addFirst(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }

    public ListNode reverseList2(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            ListNode forw = curr.next;
            curr.next = null;
            addFirst(curr);
        }

        return th;
    }

    // reverse doubly linkedlist
    public void reverse(ListNode head) {

        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}





/**
Reverse Linked List II |  Medium | Adobe, Alibaba, Amazon, Facebook, Google, Microsoft |

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
 */


class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n == m)
            return head;
            
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 1;curr!=null && i<m;i++){
            prev = curr;
            curr = curr.next;
        }



        ListNode start = curr;
        ListNode end = null;
        for(int i = 1;curr!=null && i<=n-m+1;i++){
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
        }



        //fix pointers
        start.next = curr;
        if(prev!=null){
            prev.next = end;
        }else{
            head = end;
        }
        
        return head;
    }
}

