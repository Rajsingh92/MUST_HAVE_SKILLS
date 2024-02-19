/**
Combinations |  | Facebook, Google, Microsoft |

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public static void helper(int n, int k, List<List<Integer>> res, ArrayList<Integer> temp, int count,
            int lastIndex) {
        if (count > k) {
            return;
        }

        if (count == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = lastIndex + 1; i <= n; i++) {
            temp.add(i);
            helper(n, k, res, temp, count + 1, i);
            temp.remove(temp.size() - 1);
        }
    }
}




/**
Combinations

You are give a number of boxes (nboxes) and number of identical items (ritems).
You are required to place the items in those boxes and print all such configurations possible.

5
3

iii--
ii-i-
ii--i
i-ii-
i-i-i
i--ii
-iii-
-ii-i
-i-ii
--iii

*/



class Solution2 {

    public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }
        combinations(cb + 1, tb, ssf + 1, ts, asf + 'i');
        combinations(cb + 1, tb, ssf, ts, asf + '-');
    }

    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i] == 0 ? "-" : "i");
            }
            System.out.println();
            return;
        }
        for (int i = lb + 1; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                combinations(boxes, ci + 1, ti, i);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        combinations(1, nboxes, 0, ritems, "");
        combinations(new int[nboxes], 1, ritems, -1);
    }

}