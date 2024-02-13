import java.util.*;

class Solution {

    static void interLeaveQueue(Queue<Integer> q) {

        if (q.size() % 2 != 0)
            System.out.println("Input even number of integers.");

        Stack<Integer> s = new Stack<>();
        int halfSize = q.size() / 2;

        // Push first half elements into the stack
        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.poll();
        }
        // enqueue back the stack elements
        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
        }

        // dequeue the first half elements of queue and enqueue them back
        for (int i = 0; i < halfSize; i++) {
            q.add(q.peek());
            q.poll();
        }

        // push the first half elements into the stack
        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.poll();
        }

        // interleave the elements of queue and stack
        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
            q.add(q.peek());
            q.poll();
        }
    }

}
