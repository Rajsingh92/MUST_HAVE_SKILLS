/**
Pascal Triangle |  Easy | Amazon, Facebook, Google, Microsoft |

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> li = ans.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    li.add(1);
                } else {
                    int val1 = ans.get(i - 1).get(j - 1);
                    int val2 = ans.get(i - 1).get(j);
                    li.add(val1 + val2);
                }
            }
        }

        return ans;
    }
}


/**
Pascal Triangle II |  Easy | Adobe, Amazon, Google |

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
 */


class Solution {
    public List<Integer> getRow(int rowIndex) {

        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
}

