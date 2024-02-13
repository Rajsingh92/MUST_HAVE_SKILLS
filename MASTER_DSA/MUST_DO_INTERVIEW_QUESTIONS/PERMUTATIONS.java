/**
Permutations |  | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

Given an array nums of distinct integers, return all the possible permutations. You can return the answer 
in any order.


Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */

import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] spots = new int[nums.length];
        Arrays.fill(spots, -100);
        helper(res, spots, nums, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] spots, int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> al = new ArrayList<>();

            for (int te : spots)
                al.add(te);

            res.add(al);
            return;
        }

        int val = nums[idx];
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == -100) {
                spots[i] = val;
                helper(res, spots, nums, idx + 1);
                spots[i] = -100;
            }
        }
    }
}


/**
Permutations - 1

1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.

5  3

12300
12030
12003
102..
.....

*/


class Main {

    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }


        for (int i = 0; i < items.length; i++) {
            if (items[i] == 0) {
                items[i] = cb;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                items[i] = 0;
            }
        }
        permutations(cb + 1, tb, items, ssf, ts, asf + 0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
    }

}





/**
Permutations II |  | Adobe, Amazon, Facebook |

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in 
any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 */

class Solution {
    HashSet <List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean used[] = new boolean[nums.length];
        permute(new ArrayList<Integer>(),nums, used);
        return new ArrayList(set);
    }
    
    public void permute(List<Integer> permutation, int []nums,  boolean used[]){
                
        if(permutation.size() == nums.length){
            set.add(new ArrayList<Integer>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                permutation.add(nums[i]);
                used[i] = true;
                permute(permutation, nums, used);
                permutation.remove(permutation.size()-1);
                used[i] =false;
            }

        }
        
    }
}