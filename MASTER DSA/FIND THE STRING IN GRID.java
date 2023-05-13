/**
Find the string in grid 

Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched 
in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction 
(not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically 
down and 4 diagonal directions.
 

Example 1:

Input: grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: {{0,0}}
Expalnation: From (0,0) one can find "abc"
in horizontally right direction.
 */

import java.util.*;
class Solution {
    private int M, N;

    public int[][] searchWord(char[][] grid, String word) {
        
        int n = grid.length;
        int m = grid[0].length;
        this.M = m;
        this.N = n;

        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0) && search2D(grid, i, j, word)) {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(i);
                    l.add(j);
                    al.add(l);
                }
            }
        }
        int[][] result = new int[al.size()][2];
        for (int i = 0; i < al.size(); i++) {
            result[i][0] = al.get(i).get(0);
            result[i][1] = al.get(i).get(1);
        }
        return result;
    }

    boolean search2D(char[][] grid, int row, int col, String word) {

        int[] x = new int[] { 0, 0, -1, 1, -1, -1, 1, 1 };
        int[] y = new int[] { -1, 1, 0, 0, -1, 1, -1, 1 };

        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {

            int k;
            int nr = row + x[dir];
            int nc = col + y[dir];

            for (k = 1; k < len; k++) {
                if (nr >= this.N || nr < 0 || nc >= this.M || nc < 0 || grid[nr][nc] != word.charAt(k))
                    break;

                nr += x[dir];
                nc += y[dir];
            }

            if (k == len)
                return true;
        }

        return false;
    }
}