import java.util.*;

// Normal Queue
class NormalQueue {

    public static class Queue {
        int[] data;
        int front;
        int size;

        public Queue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue overflow");
            } else {
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];

                front = (front + 1) % data.length;
                size--;

                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];
                return val;
            }
        }
    }
}

// Dynamic Queue

class DynamicQueue {

    public static class Queue {
        int[] data;
        int front;
        int size;

        public Queue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (front + i) % data.length;
                    ndata[i] = data[idx];
                }
                data = ndata;
                front = 0;
            }

            int idx = (front + size) % data.length;
            data[idx] = val;
            size++;
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];

                front = (front + 1) % data.length;
                size--;

                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];
                return val;
            }
        }
    }

}

// | Implement Queue using Stacks | Apple, Microsoft |

public class Main {
    // add efficient
    public static class StackToQueueAdapter1 {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter1() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.push(mainS.pop());
                }

                int val = mainS.pop();

                while (helperS.size() > 0) {
                    mainS.push(helperS.pop());
                }

                return val;
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.push(mainS.pop());
                }

                int val = mainS.pop();
                helperS.push(val);

                while (helperS.size() > 0) {
                    mainS.push(helperS.pop());
                }

                return val;
            }
        }
    }

    // remove efficient
    public static class StackToQueueAdapter2 {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter2() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            while (mainS.size() > 0) {
                helperS.push(mainS.pop());
            }

            mainS.push(val);

            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.pop();
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.peek();
            }
        }
    }
}

// Queue Using LinkedList
class LL {

    public static class LLToQueueAdapter {
        LinkedList<Integer> list;

        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }
}

// design cirxular deque
public class Main {
    public static class MyCircularDeque<T> {

        public class Node {
            T data;
            Node next;
            Node pre;

            Node() {
                data = null;
            }

            Node(T value) {
                data = value;
            }

            public void delete() {
                next.pre = pre;
                pre.next = next;
            }
        }

        final private Node head;
        final private Node tail;
        private int size;

        /** Initialize your data structure here. */
        public MyCircularDeque() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        /**
         * Adds an item at the front of Deque.
         */
        public void insertFront(T value) {
            Node n = new Node(value);
            n.next = head.next;
            head.next = n;
            n.next.pre = n;
            n.pre = head;
            size++;
        }

        /**
         * Adds an item at the rear of Deque.
         */
        public void insertLast(T value) {
            Node n = new Node(value);
            n.next = tail;
            n.pre = tail.pre;
            n.pre.next = n;
            tail.pre = n;
            size++;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is
         * successful.
         */
        public T deleteFront() {
            if (size == 0)
                return null;

            Node n = head.next;
            T value = n.data;
            n.delete();
            size--;
            return value;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is
         * successful.
         */
        public T deleteLast() {
            if (size == 0)
                return null;

            Node n = tail.pre;
            T value = n.data;

            n.delete();
            size--;
            return value;
        }

        /** Get the front item from the deque. */
        public T getFront() {
            if (size == 0)
                return null;
            return head.next.data;
        }

        /** Get the last item from the deque. */
        public T getRear() {
            if (size == 0)
                return null;
            return tail.pre.data;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }
    }
}

// Efficiently Implement K Queues Single Array
public class KQueues {

    int k;
    int n;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;

    KQueues(int k, int n) {

        // Initialize n and k, and allocate memory for all arrays
        this.k = k;
        this.n = n;
        this.arr = new int[n];
        this.front = new int[k];
        this.rear = new int[k];
        this.next = new int[n];

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = rear[i] = -1;
        }

        // Initialize all spaces as free
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;

    }

    // To check whether queue number 'i' is empty or not
    private boolean isEmpty(int i) {
        return front[i] == -1;
    }

    // To dequeue an from queue number 'i' where i is from 0 to k-1
    private boolean isFull(int i) {
        return free == -1;
    }

    // To enqueue an item in queue number 'j' where j is from 0 to k-1
    private void enqueue(int item, int j) {
        if (isFull(j)) {
            System.out.println("queue overflow");
            return;
        }

        int nextFree = next[free];

        if (isEmpty(j)) {
            rear[j] = front[j] = free;
        } else {
            // Update next of rear and then rear for queue number 'j'
            next[rear[j]] = free;
            rear[j] = free;
        }
        next[free] = -1;

        // Put the item in array
        arr[free] = item;

        // Update index of free slot to index of next slot in free list
        free = nextFree;
    }

    // To dequeue an from queue number 'i' where i is from 0 to k-1
    private int dequeue(int i) {
        // Underflow checkSAS
        if (isEmpty(i)) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }

        // Find index of front item in queue number 'i'
        int frontIndex = front[i];

        // Change top to store next of previous top
        front[i] = next[frontIndex];

        // Attach the previous front to the beginning of free list
        next[frontIndex] = free;
        free = frontIndex;

        return arr[frontIndex];
    }

}
