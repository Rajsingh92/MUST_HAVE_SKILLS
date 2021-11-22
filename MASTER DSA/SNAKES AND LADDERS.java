/**
Snakes and Ladders  | Amazon |

On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:


You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
(This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.

Example 1:

Input: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
 */

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int ans = 0;
        boolean[][] visited = new boolean[n][n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[n - 1][0] = true;

        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.removeFirst();

                if (rem == n * n) {
                    return ans;
                }

                for (int x = 1; x <= 6; x++) {
                    if (rem + x <= n * n) {
                        int pos[] = findCoordinates(rem + x, n);

                        int row = pos[0];
                        int col = pos[1];

                        if (visited[row][col] == false) {

                            if (board[row][col] == -1) {
                                queue.addLast(rem + x);
                            } else {
                                queue.addLast(board[row][col]);
                            }

                            visited[row][col] = true;
                        }
                    }
                }
            }
            ans++;
        }

        return -1;
    }

    public int[] findCoordinates(int curr, int n) {
        int r = n - (curr - 1) / n - 1;
        int c = (curr - 1) % n;

        if (r % 2 == n % 2) {
            return new int[] { r, n - 1 - c };
        } else {
            return new int[] { r, c };
        }
    }
}
