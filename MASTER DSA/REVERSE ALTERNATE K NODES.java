
class Solution {

    Node kAltReverse(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (node != null) {
            node.next = current;
        }


        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }

        return prev;
    }

}
