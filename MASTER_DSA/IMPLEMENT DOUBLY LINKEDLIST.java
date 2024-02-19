class DoublyLinkedList {
    private class Node {
        int data = 0;
        Node prev = null;
        Node next = null;

        Node(int data) {
            this.data = data;
        }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = this.head;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");

        return sb.toString();
    }

    private boolean ListIsEmptyException() {
        if (this.size == 0) {
            System.out.print("ListIsEmpty: ");
            return true;
        }
        return false;
    }

    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
        if (index < leftRange || index > rightRange) {
            System.out.print("IndexIsInValid: ");
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void addFirstNode(Node node) {
        if (this.size == 0)
            this.head = this.tail = node;
        else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        addFirstNode(node);
    }

    private void addLastNode(Node node) {
        if (this.size == 0)
            this.head = this.tail = node;
        else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        addLastNode(node);
    }

    private void addNodeAt(int index, Node node) {
        if (index == 0)
            addFirstNode(node);
        else if (index == this.size)
            addLastNode(node);
        else {
            Node forw = getNodeAt(index);
            Node prev = forw.prev;

            prev.next = node;
            node.prev = prev;

            node.next = forw;
            forw.prev = node;

            this.size++;
        }
    }

    public void addAt(int index, int data) {
        if (indexIsInvalidException(index, 0, this.size))
            System.out.println(-1);
        else {
            Node node = new Node(data);
            addNodeAt(index, node);
        }
    }

    public void addBefore(Node refNode, int data) {
        Node node = new Node(data);
        Node prev = refNode.prev;

        if (prev == null) {
            node.next = refNode;
            refNode.prev = node;
            this.head = node;
        } else {
            prev.next = node;
            node.prev = prev;

            node.next = refNode;
            refNode.prev = node;
        }

        this.size++;
    }

    public void addBefore(int idx, int data) {
        Node node = getNodeAt(idx);
        addBefore(node, data);
    }

    public void addAfter(Node refNode, int data) {
        Node node = new Node(data);
        Node forw = refNode.next;

        if (forw == null) {
            refNode.next = node;
            node.prev = refNode;
            this.tail = node;
        } else {
            forw.prev = node;
            node.next = forw;

            node.prev = refNode;
            refNode.next = node;
        }

        this.size++;
    }

    public void addAfter(int idx, int data) {
        Node node = getNodeAt(idx);
        addAfter(node, data);
    }

    private Node removeFirstNode() {
        Node node = this.head;
        if (this.size == 1)
            this.head = this.tail = null;
        else {
            Node nextNode = this.head.next;
            nextNode.prev = null;
            node.next = null;

            this.head = nextNode;
        }

        this.size--;
        return node;
    }

    public int removeFirst() {
        if (ListIsEmptyException())
            return -1;
        Node node = removeFirstNode();
        return node.data;
    }

    private Node removeLastNode() {
        Node node = this.tail;
        if (this.size == 1)
            this.head = this.tail = null;
        else {
            Node prevNode = this.tail.prev;
            prevNode.next = null;
            node.prev = null;

            this.tail = prevNode;
        }

        this.size--;
        return node;
    }

    public int removeLast() {
        if (ListIsEmptyException())
            return -1;
        Node node = removeLastNode();
        return node.data;
    }

    private Node removeAtNode(int index) {
        if (index == 0)
            return removeFirstNode();
        else if (index == this.size - 1)
            return removeLastNode();
        else {
            Node node = getNodeAt(index);
            Node prev = node.prev;
            Node forw = node.next;

            prev.next = forw;
            forw.prev = prev;

            node.next = null;
            node.prev = null;

            this.size--;
            return node;
        }
    }

    public int removeAt(int index) {
        if (ListIsEmptyException())
            return -1;
        if (indexIsInvalidException(index, 0, this.size - 1))
            return -1;

        Node node = removeAtNode(index);
        return node.data;
    }

    public int getFirst() {
        if (ListIsEmptyException())
            return -1;

        return this.head.data;
    }

    public int getLast() {
        if (ListIsEmptyException())
            return -1;

        return this.tail.data;
    }

    private Node getNodeAt(int index) {
        Node curr = this.head;
        while (index-- > 0)
            curr = curr.next;

        return curr;
    }

    public int getAt(int index) {
        if (ListIsEmptyException())
            return -1;
        else if (indexIsInvalidException(index, 0, this.size - 1))
            return -1;

        Node node = getNodeAt(index);
        return node.data;
    }

    // insert in sorted doubly linked list
    public static Node sortedInsert(Node head, int x) {
        Node curr;
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
        } else if (head.data >= newNode.data) {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        } else {
            curr = head;
            while (curr.next != null && curr.next.data < newNode.data)
                curr = curr.next;

            newNode.next = curr.next;
            if (curr.next != null)
                newNode.next.prev = newNode;

            curr.next = newNode;
            newNode.prev = curr;

        }
        return head;
    }
}







