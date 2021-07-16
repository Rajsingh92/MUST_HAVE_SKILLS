/**
Find K Closest Elements |  Medium | Facebook |

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result 
should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int index = binarySearch(arr, x);
        int left = index - 1;
        int right = index;
        List<Integer> ans = new ArrayList<>();

        while (left >= 0 && right < arr.length && k > 0) {
            if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
                ans.add(arr[left]);
                left--;
                k--;
            } else {
                ans.add(arr[right]);
                right++;
                k--;
            }
        }

        while (k > 0 && left >= 0) {
            ans.add(arr[left]);
            left--;
            k--;
        }

        while (k > 0 && right < arr.length) {
            ans.add(arr[right]);
            right++;
            k--;
        }

        Collections.sort(ans);

        return ans;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return mid;
    }
}