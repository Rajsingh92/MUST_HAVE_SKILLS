public class Solution{

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; --i) { // 3, 4, 5, 2, 1
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; --j) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j); // 3,5,4,2,1

                        reverse(nums, i + 1, nums.length - 1); // [4,2,1] reverse to [1,2,4] => 3, 5, 1, 2, 4
                        return;
                    }
                }

            }
        }

        reverse(nums, 0, nums.length - 1); // if return，then reverse
    }

    private void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    private void reverse(int[] nums, int i, int j) {

        while (i < j) {

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            i++;
            j--;
        }
    }
}