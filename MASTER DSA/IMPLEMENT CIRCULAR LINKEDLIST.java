public class CircularLinkedList {
    
    public static Node sortedInsert(Node head, int data) {
        Node curr = head;
        Node new_node = new Node(data);

        if (curr == null) {
            new_node.next = new_node;
            head = new_node;
        } else if (curr.data >= new_node.data) {
            while (curr.next != head)
                curr = curr.next;

            curr.next = new_node;
            new_node.next = head;
            head = new_node;
        } else {
            while (curr.next != head && curr.next.data < new_node.data)
                curr = curr.next;

            new_node.next = curr.next;
            curr.next = new_node;
        }

        return head;
    }
}


