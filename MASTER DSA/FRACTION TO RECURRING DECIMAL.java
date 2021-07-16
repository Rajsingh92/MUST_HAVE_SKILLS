/**
Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 */

import java.util.*;
class Solution {
    public String fractionToDecimal(int numeratorOriginal, int denominatorOriginal) {
        if (numeratorOriginal == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        long n1 = numeratorOriginal > 0 ? 1 : -1;
        long n2 = denominatorOriginal > 0 ? 1 : -1;
        String sign = n1 * n2 > 0 ? "" : "-";

        sb.append(sign);
        long numerator = Math.abs((long) numeratorOriginal);
        long denominator = Math.abs((long) denominatorOriginal);

        long quo = numerator / denominator;
        long rem = numerator % denominator;
        sb.append(quo);

        if (rem == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }

        HashMap<Long, Integer> map = new HashMap<>(); // rem to pos
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(rem, sb.length());

                rem = rem * 10;
                quo = rem / denominator;
                rem = rem % denominator;
                sb.append(quo);
            }
        }

        return sb.toString();
    }
}