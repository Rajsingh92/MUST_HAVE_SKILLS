/**
Find Missing And Repeating 
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and 
one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
 */



class Solve {
    int[] findTwoElement(int arr[], int n) {

        Map<Integer, Boolean> numberMap = new HashMap<>();

        int[] res = new int[2];

        for (Integer i : arr) {

            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            } else {
                res[0] = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (numberMap.get(i) == null) {
                res[1] = i;
            }
        }

        return res;
    }

    // O(n)
    int[] findTwoElement2(int arr[], int n) {

 
        int[] res = new int[2];

        int Sum_N = (n * (n + 1)) / 2;
        int Sum_NSq = (n * (n + 1) * (2 * n + 1)) / 6;
        int missingNumber = 0, repeating = 0;
 
        for (int i = 0; i < n; i++) 
        {
            Sum_N -= arr[i];
            Sum_NSq -= arr[i] * arr[i];
        }
 
        missingNumber = (Sum_N + Sum_NSq / Sum_N) / 2;
        repeating = missingNumber - Sum_N;
        
        res[0] = repeating;
        res[1] = missingNumber;
        
        
        return res;
    }

    int[] findTwoElement3(int[] arr, int n) {
        int[] res = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                res[0] = Math.abs(arr[i]); // repeating number
            } else {
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1]; // first time visit make it negative
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                res[1] = i+1;
            }
        }

        return res;
    }
}

/**
Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing 
from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */



class Solution {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }

        int expected = n * (n + 1) / 2;
        return Math.abs(sum - expected);
    }
}

/**
Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            
            if(nums[index]>0){
                nums[index] = -nums[index];
            }else{
                res.add(Math.abs(index+1));
            }
        }
        
        
        return res;
    }
}

/**
Find the Duplicate Number |  Medium | Adobe, Amazon, Google, Microsoft |
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
 */



class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        if (nums.length == 0)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);

            if (nums[temp] > 0)
                nums[temp] *= -1;
            else
                return temp;
        }
        return -1;
    }
}





