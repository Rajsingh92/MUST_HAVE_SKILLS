/** 
Delete N nodes after M nodes of a linked list 

Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the linked list and next M and N respectively space separated. The last line contains the elements of the linked list.

Output:
Function should not print any output to stdin/console.

User Task:
The task is to complete the function linkdelete() which should modify the linked list as required.

Example:
Input:
2
8
2 1
9 1 3 5 9 4 10 1
6
6 1
1 2 3 4 5 6

Output: 
9 1 5 9 10 1
1 2 3 4 5 6
 */

class Solution {
    static void linkdelete(Node head, int M, int N) {
        Node curr = head;

        while (curr != null) {

            int count = 1;
            while (count < M && curr != null) {
                count++;
                curr = curr.next;
            }

            if (curr == null)
                return;

            Node temp = curr.next;
            count = 1;
            while (count <= N && temp != null) {
                count++;
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;
        }
    }
}