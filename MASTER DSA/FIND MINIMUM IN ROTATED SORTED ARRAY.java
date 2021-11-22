/**
Find Minimum in Rotated Sorted Array |  Medium | Google |

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the 
array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */


class Solution {
    public int findMin(int[] num) {
        int low = 0;
        int high = num.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (num[mid] > num[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return num[low];
    }
}




/**
Find Minimum in Rotated Sorted Array II |  Hard | Facebook, Google |

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the 
array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

 

Example 1:

Input: nums = [1,3,5]
Output: 1
 */



class Solution2 {
	public int findMin(int[] num) {
		int low = 0;
		int high = num.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (num[mid] > num[high]) {
				low = mid + 1;
			} else if (num[mid] < num[high]) {
				high = mid;
			} else {
				high--;
			}
		}

		return num[low];
	}
}
