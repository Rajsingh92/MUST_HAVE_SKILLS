/**
Maximum Frequency Stack | Hard | Amazon |

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]
 */

 import java.util.*;
 
class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        if (freq > maxFreq)
            maxFreq = freq;

        freqMap.put(val, freq);

        if (freqStack.containsKey(freq)) {
            Stack<Integer> st = freqStack.get(freq);
            st.push(val);
            freqStack.put(freq, st);
        } else {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            freqStack.put(freq, st);
        }
    }

    public int pop() {
        Stack<Integer> st = freqStack.get(maxFreq);
        int val = st.pop();
        if (st.size() == 0) {
            maxFreq--;
        }
        freqMap.put(val, freqMap.get(val) - 1);
        return val;
    }
}
