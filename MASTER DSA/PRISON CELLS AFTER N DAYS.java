/**
Prison Cells After N Days |  Medium | Amazon |

There are 8 prison cells in a row and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the 
ith cell is vacant, and you are given an integer n.

Return the state of the prison after n days (i.e., n such changes described above).

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], n = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 */

 
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {

        HashSet<String> set = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;

        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);

            if (set.contains(key) == false) {
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }

            cells = next;
        }
        
        // get the size of cycle as pattern will be repeating again and again
        n = n % cycle;
        if (hasCycle) {
            for (int i = 0; i < n; i++) {
                cells = nextDay(cells);
            }
        }

        return cells;
    }

    public int[] nextDay(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] == arr[i + 1]) {
                temp[i] = 1;
            }
        }

        return temp;
    }
}