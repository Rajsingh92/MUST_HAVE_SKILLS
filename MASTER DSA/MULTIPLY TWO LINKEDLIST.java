import java.util.*;

class Main {
   
    public static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode forw = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = forw;
        }

        return prev;
    }

    public static void multiplyLinkedListWithDigit(ListNode l1, int digit, ListNode ans) {
        ListNode curr = ans; // dummy.

        int carry = 0;
        while (l1 != null || carry != 0) {
            int sum = carry + (l1.val * digit);

            carry = sum / 10;
            sum = sum % 10;

            if (curr.next != null)
                curr.next.val += sum;
            else
                curr.next = new ListNode(sum);

            l1 = l1.next;
            curr = curr.next;
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode ans = new ListNode(-1); // dummy.
        ListNode ans_itr = ans;
        ListNode l2_itr = l2;

        while (l2_itr != null) {
            multiplyLinkedListWithDigit(l1, l2_itr.val, ans);
            l2_itr = l2_itr.next;
            ans_itr = ans_itr.next;
        }

        return reverseList(ans);
    }
}

