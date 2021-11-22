import java.util.*;

class Main {

    public static ListNode segregate01(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode Zero = new ListNode(-1);
        ListNode zp = Zero;

        ListNode Ones = new ListNode(-1);
        ListNode op = Ones;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else {
                op.next = curr;
                op = op.next;
            }

            curr = curr.next;
        }

        op.next = null;
        zp.next = Ones.next;

        return Zero.next;
    }

}


/**
Sort a binary array using one traversal
Given a binary array, sort it using one traversal and no extra space.

Examples :

Input : 1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0 
Output : 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
Explanation: The output is a sorted array of 0 and 1
 */


class Solution {
    public static void sort(int[] arr) {
        int czero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                czero++;
            }
        }

        int k = 0;
        while (k < czero) {
            arr[k] = 0;
            k++;
        }

        while (k < arr.length) {
            arr[k] = 1;
            k++;
        }
    }

    public static void sort2(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

