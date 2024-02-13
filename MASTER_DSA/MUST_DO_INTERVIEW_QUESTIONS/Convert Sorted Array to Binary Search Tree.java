import java.util.Arrays;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

	public static void main(String[] args) {
		Convert_Sorted_Array_to_Binary_Search_Tree out = new Convert_Sorted_Array_to_Binary_Search_Tree();
		Solution s = out.new Solution();

		int[] a = {1,2,3,4,5};

		int[] b = Arrays.copyOfRange(a, 0, a.length);
		System.out.println(Arrays.toString(b));

//		b = Arrays.copyOfRange(a, 2, 1); // error, must to > from

		b = Arrays.copyOfRange(a, 2, 2); // ok, empty array returned
		System.out.println("a, 2, 2: " + Arrays.toString(b));

//		b = Arrays.copyOfRange(a, -1, 10); // error, out of boundary
//		System.out.println("a, -1, 10" + Arrays.toString(b));

		b = Arrays.copyOfRange(a, a.length, a.length); // ok, empty array returned
		System.out.println("a, a.length, a.length: " + Arrays.toString(b));

	}


	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {

	        if (nums == null || nums.length == 0)     return null;

            return dfs(nums, 0 , nums.length - 1);
        }

        TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) return null;
            int mid = left + (right - left) / 2;
            TreeNode cur = new TreeNode(nums[mid]);
            cur.left = dfs(nums, left, mid - 1);
            cur.right = dfs(nums, mid + 1, right);
            return cur;
        }

	}

}