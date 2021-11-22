
/**
Remove Duplicate Letters |  Hard | Microsoft |
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure 
your result is the smallest in lexicographical order among all possible results.



Example 1:

Input: s = "bcabc"
Output: "abc"
 */
import java.util.*;

class Main {
    public String removeDuplicateLetters(String s) {

        int n = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';

            freq[index]--;

            if (visited[index])
                continue;

            while (!st.isEmpty() && freq[st.peek() - 'a'] != 0 && ch < st.peek()) {
                visited[st.pop() - 'a'] = false;
            }

            st.push(ch);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}