
/**
Min Stack |  Easy | Adobe, Amazon, Apple, Facebook, Google, Microsoft |
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
 */

import java.util.*;

class Solution {
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
            allData.push(val);
            if (minData.size() == 0 || val <= minData.peek()) {
                minData.push(val);
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = allData.pop();
                if (val == minData.peek()) {
                    minData.pop();
                }
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return allData.peek();
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return minData.peek();
            }
        }
    }
}

class MinStack {
    Stack<Long> st = new Stack<>();
    long globalMin = 0;

    public MinStack() {

    }

    public void push(int x) {
        long val = x;
        if (st.size() == 0) {
            st.push(val);
            globalMin = val;
            return;
        }

        if (val < globalMin) {
            st.push((val - globalMin) + val);
            globalMin = val;
        } else {
            st.push(val);
        }
    }

    public void pop() {
        if (st.peek() < globalMin) {
            globalMin = (globalMin - st.peek()) + globalMin;
        }

        st.pop();

    }

    public int top() {
        if (st.peek() < globalMin)
            return (int) globalMin;

        return (int) ((long) st.peek());
    }

    public int getMin() {
        return (int) globalMin;
    }
}


/**
Max Stack | Facebook |

Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 */


class Solution {
    public static class MyStack {
        Stack<Integer> s = new Stack<Integer>();
        int maxEle;

        public int getMax() {
            if (s.empty())
                System.out.print("Stack is empty\n");
            else
                return maxEle;
        }

        public int top() {
            if (s.empty()) {
                System.out.print("Stack is empty ");
                return -1;
            }
            if (s.peek() > maxEle) {
                return maxEle;
            } else {
                return s.peek();
            }
        }

        public void pop() {
            if (s.empty()) {
                System.out.print("Stack is empty\n");
                return;
            }

            if (s.peek() > maxEle) {
                maxEle = 2 * maxEle - t;
            }
            s.pop();
        }

        public void push(int x) {
            if (s.empty()) {
                maxEle = x;
                s.push(x);
                return;
            }

            if (x > maxEle) {
                s.push(2 * x - maxEle);
                maxEle = x;
            } else {
                s.push(x);
            }
        }
    };

}


