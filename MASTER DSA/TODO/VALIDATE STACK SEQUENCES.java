
/**
Validate Stack Sequences
Given two sequences pushed and popped with distinct values, return true if and only if this could have 
been the result of a sequence of push and pop operations on an initially empty stack.

 

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;

        for (int x : pushed) {
            st.push(x);
            while (!st.empty() && st.peek() == popped[i]) {
                st.pop();
                i++;
            }
        }

        return st.size() == 0;

    }
}