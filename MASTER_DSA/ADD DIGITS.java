/**
Add Digits |  Easy | Adobe, Apple |

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.  Since 2 has only one digit, return it.
 */

class Solution {
    public int addDigits(int num) {
        int sum =0;
        while(num>0){
            sum+=num%10;
            num = num/10;
            
            if(num == 0 && sum>9){
                num = sum;
                sum = 0;
            }
        }
        
        return sum;
    }

    public int addDigits2(int num) {
        if(num == 0){
            return 0;
        }
        // number can be represent as 9n+k
        if(num%9==0){
            return 9;
        }else{
            return num%9;
        }
    }
}