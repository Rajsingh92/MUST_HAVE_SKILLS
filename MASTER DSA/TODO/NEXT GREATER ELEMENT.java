/**
Next Greater Element I |  Easy | Amazon, Google |

You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
 */


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<>();

        nge[nums2.length - 1] = -1;
        st.push(nums2[nums2.length - 1]);

        for (int i = nums2.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < nums2[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(nums2[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nge.length; i++) {
            map.put(nums2[i], nge[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}

// Next Greater Element II |  Medium | Microsoft |