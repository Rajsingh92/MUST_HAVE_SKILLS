/**
Can Make Arithmetic Progression From Sequence
Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between 
any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.


Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each 
consecutive elements.
 */

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<=1){
            return true;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        
        for(int val : arr){
            set.add(val);
            first = Math.min(first,val);
            last = Math.max(last,val);
        }
        
        int d = (last-first)/(arr.length-1);
        
        for(int i=0 ;i<arr.length;i++){
            int ai = first + i*d;
            if(set.contains(ai) == false){
                return false;
            }
        }
        
        return true;
    }
}