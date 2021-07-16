/**
Intersection of Two Arrays |  Easy | Amazon, Apple, Facebook, Google, Microsoft |


Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int val : nums1) {
            set1.add(val);
        }

        for (int val : nums2) {
            if (set1.contains(val)) {
                set2.add(val);
            }
        }

        int res[] = new int[set2.size()];
        int k = 0;

        for (int val : set2) {
            res[k++] = val;
        }

        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
        for (int val : set) {
            res[k++] = val;
        }

        return res;
    }
}


/**
Intersection of Two Arrays II |  Easy | Amazon |

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] res = new int[list.size()];
        int k = 0;
        for (int val : list) {
            res[k++] = val;
        }

        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> fmap = new HashMap<>(); // val to freq

        for (int i = 0; i < nums1.length; i++) {
            fmap.put(nums1[i], fmap.getOrDefault(nums1[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            int val = nums2[i];
            if (fmap.containsKey(val) && fmap.get(val) > 0) {
                list.add(val);
                fmap.put(val, fmap.get(val) - 1);
            }
        }

        int[] res = new int[list.size()];
        int k = 0;
        for (int temp : list) {
            res[k++] = temp;
        }

        return res;
    }
}