
import java.util.*;

class Main {

    // SEGEREGATE NODE OF LINKEDLIST OVER PIVOT INDEX
    public static ListNode segregate(ListNode head, int idx) {
        if (head == null || head.next == null)
            return head;

        int i = 0, data = 0;
        ListNode curr = head;
        while (curr != null) {
            if (i == idx)
                data = curr.val;

            i++;
            curr = curr.next;
        }

        ListNode smaller = new ListNode(-1);
        ListNode sp = smaller;

        ListNode greater = new ListNode(-1);
        ListNode gp = greater;

        i = 0;
        curr = head;
        ListNode pivot = null;
        while (curr != null) {
            if (i == idx) {
                pivot = curr;
            } else if (curr.val <= data) {
                sp.next = curr;
                sp = sp.next;
            } else {
                gp.next = curr;
                gp = gp.next;
            }

            curr = curr.next;
            i++;
        }

        sp.next = pivot;
        pivot.next = greater.next;
        gp.next = null;
        sp = sp.next;

        return smaller.next;
    }

    // SEGEREGATE NODE OF LINKEDLIST OVER LAST INDEX
    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode small = new ListNode(-1); // all Nodes smaller or equal to given data.
        ListNode sp = small; // smaller previous

        ListNode greater = new ListNode(-1); // all Nodes greater than given data.
        ListNode gp = greater; // greater previous

        ListNode tail = head;
        while (tail.next != null)
            tail = tail.next;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val <= tail.val) {
                sp.next = curr;
                sp = sp.next;
            } else {
                gp.next = curr;
                gp = gp.next;
            }

            curr = curr.next;
        }

        gp.next = null;
        sp.next = greater.next;

        small.next = null;
        greater.next = null;

        return sp;
    }
}
