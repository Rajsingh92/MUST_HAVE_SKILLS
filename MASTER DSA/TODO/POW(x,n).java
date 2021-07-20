/**
Pow(x, n) |  Medium | Adobe, Alibaba, Amazon, Apple, Facebook, Microsoft |

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
 */

class Solution {
    public double myPow(double x, int n) {
        if (n >= 0)
            return positive(x, n);
        else
            return negative(x, n);
    }

    private double negative(double x, int n) {
        if (n == -1)
            return 1 / x;

        double smallOutput = myPow(x, n / 2);
        if (n % 2 == 0)
            return smallOutput * smallOutput;
        else
            return (1 / x) * smallOutput * smallOutput;
    }

    private double positive(double x, int n) {
        if (n == 0)
            return 1;

        double smallOutput = myPow(x, n / 2);

        if (n % 2 == 0)
            return smallOutput * smallOutput;
        else
            return x * smallOutput * smallOutput;
    }

}