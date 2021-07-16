
class Solution {

    public static Node findcriticalnode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head.next;
        while (curr != null) {
            if (curr.data < curr.prev.data) {
                break;
            }
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }

        curr.prev.next = null;
        curr.prev = null;
        curr = reverse(curr);
        return mergeLists(head, curr);
    }

    public static Node reverse(Node head) {
        Node temp = null;
        Node curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
            return head;
        }
    }

    public static Node mergeLists(Node first, Node second) {

        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}
