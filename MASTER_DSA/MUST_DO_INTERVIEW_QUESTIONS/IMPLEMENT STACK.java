import java.util.*;

// Normal Stack
class NormalStack {
    public class Stack {
        int[] data;
        int top;

        public Stack(int cap) {
            data = new int[cap];
            top = -1;
        }

        public int size() {
            return top + 1;
        }

        public void display() {
            for (int i = top; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        public void push(int val) {
            if (top == data.length - 1) {
                System.out.print("Stack Overflow");
            } else {
                top++;
                data[top] = val;
            }
        }

        public int pop() {
            if (top == -1) {
                System.out.print("Stack Underflow");
                return -1;
            } else {
                int val = data[top];
                top--;
                return val;
            }
        }

        public int peek() {
            if (top == -1) {
                System.out.print("Stack Underflow");
                return -1;
            } else {
                int val = data[top];
                return val;
            }
        }
    }
}

// Dynamic Stack

class DynamicStack {
    public class Stack {
        int[] data;
        int top;

        public Stack(int cap) {
            data = new int[cap];
            top = -1;
        }

        public int size() {
            return top + 1;
        }

        public void display() {
            for (int i = top; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        public void push(int val) {
            if (top == data.length - 1) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }
                data = ndata;
            }

            top++;
            data[top] = val;
        }

        public int pop() {
            if (top == -1) {
                System.out.print("Stack Underflow");
                return -1;
            } else {
                int val = data[top];
                top--;
                return val;
            }
        }

        public int peek() {
            if (top == -1) {
                System.out.print("Stack Underflow");
                return -1;
            } else {
                int val = data[top];
                return val;
            }
        }
    }
}

// | Implement Stack using Queues | Microsoft |

class Main {

    // push efficient
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }

                int val = mainQ.remove();

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }

                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }

                int val = mainQ.remove();
                helperQ.add(val);

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }

                return val;
            }
        }
    }

    // pop efficient
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            while (mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }

            mainQ.add(val);

            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return mainQ.remove();
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return mainQ.peek();
            }
        }
    }

}

// Stack using linkedlist
class Main {

    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = list.getFirst();
                list.removeFirst();
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = list.getFirst();
                return val;
            }
        }
    }

}

// Stack using priority queue
class Solution {
    static class Stack {
        private class Node implements Comparable<Node> {
            int value;
            int count;

            public Node(int value, int count) {
                this.value = value;
                this.count = count;
            }

            @Override
            public int compareTo(Node o) {
                return this.count - o.count;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count;

        public Stack() {
            this.count = 0;
        }

        public void push(int item) {
            count++;
            Node node = new Node(item, count);
            pq.add(node);
        }

        public int pop() {
            if (pq.size() == 0) {
                return -1;
            }
            int rv = pq.remove().value;
            return rv;
        }

        public void display() {
            Node[] data = new Node[pq.size()];
            int k = 0;
            while (pq.isEmpty() == false) {
                Node rn = pq.remove();
                System.out.print(rn.value + " ");
                data[k++] = rn;
            }

            for (int i = 0; i < data.length; i++) {
                pq.add(data[i]);
            }
        }

    }
}

/**
 * Efficiently Implement K Stacks Single Array
 */

public class GFG {
    static class KStack {
        int arr[]; // Array of size n to store actual content to be stored in stacks
        int top[]; // Array of size k to store indexes of top elements of stacks
        int next[]; // Array of size n to store next entry in all stacks
                    // and free list
        int n, k;
        int free; // To store beginning index of free list

        // constructor to create k stacks in an array of size n
        KStack(int k1, int n1) {
            // Initialize n and k, and allocate memory for all arrays
            k = k1;
            n = n1;
            arr = new int[n];
            top = new int[k];
            next = new int[n];

            // Initialize all stacks as empty
            for (int i = 0; i < k; i++)
                top[i] = -1;

            // Initialize all spaces as free
            free = 0;
            for (int i = 0; i < n - 1; i++)
                next[i] = i + 1;
            next[n - 1] = -1; // -1 is used to indicate end of free list
        }

        // A utility function to check if there is space available
        boolean isFull() {
            return (free == -1);
        }

        // To push an item in stack number 'sn' where sn is from 0 to k-1
        void push(int item, int sn) {
            // Overflow check
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            int i = free; // Store index of first free slot

            // Update index of free slot to index of next slot in free list
            free = next[i];

            // Update next of top and then top for stack number 'sn'
            next[i] = top[sn];
            top[sn] = i;

            // Put the item in array
            arr[i] = item;
        }

        // To pop an from stack number 'sn' where sn is from 0 to k-1
        int pop(int sn) {
            // Underflow check
            if (isEmpty(sn)) {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            // Find index of top item in stack number 'sn'
            int i = top[sn];

            top[sn] = next[i]; // Change top to store next of previous top

            // Attach the previous top to the beginning of free list
            next[i] = free;
            free = i;

            // Return the previous top item
            return arr[i];
        }

        // To check whether stack number 'sn' is empty or not
        boolean isEmpty(int sn) {
            return (top[sn] == -1);
        }

    }
}
