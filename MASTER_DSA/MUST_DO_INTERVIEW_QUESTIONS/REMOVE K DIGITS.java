// Remove K Digits |  Medium | Adobe, Amazon, Facebook, Microsoft |

import java.util.*;

class Main {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        sb.reverse();

        // remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}