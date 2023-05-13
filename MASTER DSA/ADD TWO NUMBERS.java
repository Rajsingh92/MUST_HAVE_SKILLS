/**
Add Two Numbers |  Medium | Adobe, Aetion, Airbnb, Alibaba, Amazon, Apple, Facebook, Google |

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;


        ListNode head = new ListNode(-1);
        ListNode itr = head;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            int lastDigit = sum % 10;
            carry = sum / 10;

            itr.next = new ListNode(lastDigit);
            itr = itr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return head.next;
    }
}

/**
Add Two Numbers II |  Medium | Facebook, Amazon |

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next; // backup

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);

        ListNode head = new ListNode(-1);
        ListNode itr = head;

        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);

            int lastDigit = sum % 10;
            carry = sum / 10;

            itr.next = new ListNode(lastDigit);
            itr = itr.next;

            if (c1 != null) {
                c1 = c1.next;
            }
            if (c2 != null) {
                c2 = c2.next;
            }

        }

        return reverse(head.next);
    }
}




/**
Add 1 to a number represented as linked list   Plus One Linked List | Medium | Amazon, Google |

A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to 
add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
 */

class Solution {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // backup
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public static Node addOne(Node head) {

        Node dummy = new Node(-1);
        Node itr = dummy;
        head = reverseList(head);
        int carry = 1;
        
        while (head != null || carry != 0) {
            int sum = carry + (head != null ? head.data : 0);

            int lastDigit = sum % 10;
            carry = sum / 10;

            itr.next = new Node(lastDigit);
            itr = itr.next;

            if (head != null) {
                head = head.next;
            }

        }

        return reverseList(dummy.next);
    }

}

