/**
Champagne Tower |  Medium | Google |

We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.

Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)

For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.



Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)

 

Example 1:

Input: poured = 1, query_row = 1, query_glass = 1
Output: 0.00000
Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
 */



class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] glass = new double[101][101];
        glass[0][0] = (double) poured;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (glass[i][j] >= 1) {
                    double spare = glass[i][j] - 1.0;
                    glass[i][j] = 1.0;
                    glass[i + 1][j] += spare / 2.0;
                    glass[i + 1][j + 1] += spare / 2.0;
                }
            }
        }

        return glass[query_row][query_glass];
    }
}
