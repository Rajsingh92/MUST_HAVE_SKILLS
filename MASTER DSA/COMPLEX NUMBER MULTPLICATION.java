/**
Complex Number Multiplication

Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 */

class Solution {
    public String complexNumberMultiply(String a, String b) {
        int aReal = Integer.parseInt(a.substring(0, a.indexOf('+')));
        int aImag = Integer.parseInt(a.substring(a.indexOf('+') + 1, a.indexOf('i')));

        int bReal = Integer.parseInt(b.substring(0, b.indexOf('+')));
        int bImag = Integer.parseInt(b.substring(b.indexOf('+') + 1, b.indexOf('i')));

        int mulReal = aReal * bReal - aImag * bImag;
        int mulImag = aReal * bImag + bReal * aImag;
        
        return mulReal + "+" + mulImag + "i";
    }
}