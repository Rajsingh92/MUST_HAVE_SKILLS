/**
Power of Two |  Easy | Amazon |

Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n > 0 && (n & n - 1) == 0) {
            return true;
        }

        return false;
    }
}