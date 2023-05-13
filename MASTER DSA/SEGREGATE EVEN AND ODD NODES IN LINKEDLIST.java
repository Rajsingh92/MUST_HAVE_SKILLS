/**
Segregate even and odd nodes in a Linked List
modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. 
Also, keep the order of even and odd numbers same.

Examples:

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL
 */

public class Main{
    public static void oddEvenList(ListNode head){
        ListNode evenStart = null;
        ListNode evenEnd = null;
        ListNode oddStart = null;
        ListNode oddEnd = null;


        while(head!=null){
            if(head.data%2==0){
                if(evenStart==null){
                    evenStart = evenEnd = head;
                }else{
                    evenEnd.next = head;
                    evenEnd = evenEnd.next;
                }
            }else{
                if(oddStart == null){
                    oddStart = oddEnd = head;
                }else{
                    oddEnd.next = head;
                    oddEnd = oddEnd.next;
                }
            }
            head = head.next;
        }

        if(oddStart == null || evenStart == null){
            return;
        }

        head = evenStart;
        evenEnd.next = oddStart;
        oddEnd.next = null;

    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode odd = dummyOdd;
        ListNode even = dummyEven;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val % 2 != 0) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }

            curr = curr.next;
        }

        even.next = dummyOdd.next;
        odd.next = null;

        return dummyEven.next;

    }
}
