/**
Reverse String |  Easy | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

Write a function that reverses a string. The input string is given as an array of characters s.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */

class Solution {
    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }

    }
}

// Reverse a String ( using Recursion )
class Solution {
    public static void reverse(String str, int si, int ei) {
        if (si == ei) {
            System.out.print(str.charAt(si));
            return;
        }

        char ch = str.charAt(si);
        reverse(str, si + 1, ei);
        System.out.print(ch);
    }

    public static void main(String[] args) {
        String str = "Raj Singh";
        reverse(str, 0, str.length() - 1);
    }
}



