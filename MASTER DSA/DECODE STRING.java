/**
Decode String |  Medium | Amazon, appdynamics, Apple, Facebook, Google, Microsoft |

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being 
repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for 
those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
 */

import java.util.*;
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> chars = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                count = count * 10 + (c - '0');
            } else if (c == ']') {
                int repeat = nums.pop();
                String tmp = "";
                while (chars.peek() != '[') {
                    tmp = chars.pop() + tmp;
                }
                chars.pop();
                for (int j = 0; j < repeat; j++) {
                    for (int k = 0; k < tmp.length(); k++) {
                        chars.push(tmp.charAt(k));
                    }
                }
            } else {
                if (count != 0) {
                    nums.push(count);
                }
                count = 0;
                chars.push(c);
            }
        }
        String result = "";
        while (!chars.isEmpty()) {
            result = chars.pop() + result;
        }
        return result;
    }
}