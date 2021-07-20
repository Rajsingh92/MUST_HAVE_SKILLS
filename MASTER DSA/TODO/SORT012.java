/**
Given a linked list of 0s, 1s and 2s, sort it. 
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, 
and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 
0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
 */



class LinkedList
{
    static Node segregate(Node head)
    {
        Node curr = head;
        int zero =0 , one=0,two=0;
        
        while(curr!=null){
            if(curr.data==0){
                zero++;
            }else if(curr.data == 1){
                one++;
            }else if(curr.data == 2){
                two++;
            }
            curr = curr.next;
        }
        
        curr = head;
        while(curr!=null){
            if(zero>0){
                curr.data = 0;
                zero--;
            }else if(one>0){
                curr.data = 1;
                one--;
            }else if(two>0){
                curr.data = 2;
                two--;
            }
            curr = curr.next;
        }
        
        return head;
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1);
        ListNode zp = zero;

        ListNode one = new ListNode(-1);
        ListNode op = one;

        ListNode two = new ListNode(-1);
        ListNode tp = two;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else if (curr.val == 1) {
                op.next = curr;
                op = op.next;
            } else {
                tp.next = curr;
                tp = tp.next;
            }

            curr = curr.next;
        }

        op.next = two.next;
        zp.next = one.next;
        tp.next = null;

        return zero.next;
    }
}



/**
Sort Colors |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color 
are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 */

class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

                        
                                