class Solution {

    static Node deleteKthNode(Node head, int k) {

        if (head == null)
            return null;

        if (k == 1) {
            while (head != null) {
                Node next = head.next;
                head = next;
            }

            return null;
        }

        Node ptr = head, prev = null;

        int count = 0;
        while (ptr != null) {
            count++;
            if (k == count) {
                prev.next = ptr.next;
                count = 0;
            }

            if (count != 0)
                prev = ptr;

            ptr = prev.next;
        }
        return head;
    }
}
