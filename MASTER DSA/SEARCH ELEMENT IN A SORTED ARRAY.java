/**
Single Element in a Sorted Array |  Medium | Amazon, Google |
You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once. Find this single element that appears only once.


Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
 */


class Solution {
	public int singleNonDuplicate(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		while(lo < hi){
			int mid = lo + (hi - lo)/2;
						   
			if(mid % 2 == 0){
				if(nums[mid] == nums[mid + 1]){
					lo = mid + 2;
				}else{
					hi = mid;
				}
			}else{
				if(nums[mid] == nums[mid - 1]){
					lo = mid + 1;
				}else{
					hi = mid;
				}
			}

		}
		return nums[lo];
	}
}