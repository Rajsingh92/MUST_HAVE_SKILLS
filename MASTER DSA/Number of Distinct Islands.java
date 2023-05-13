//  | 694 | Number of Distinct Islands |  Medium | Amazon, Facebook, Google, Microsoft |

// Distinct islands: island 2d coordinates sets are distinct based off its offset
class Solution {
    private static final int d [] = {0,1,0,-1,0};

    public int numDistinctIslands(int[][] grid){
        int m = grid.length, n = grid[0].length;
        Set<List<List<Integer>>> distinctIslands = new HashSet<>();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                List<List<Integer>> island = new ArrayList<>();
                if (dfs(i, j, i, j, grid, m, n, island)){
                    distinctIslands.add(island);
                }
            }
        }

        return distinctIslands.size();
    }

    private boolean dfs(int i, int j, int x, int y, int[][] grid, int m, int n, List<List<Integer>> island ){
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] <= 0) return false; // 1: island, -: visited path
        grid[x][y] = -1;
        island.add(Arrays.asList(x - i, y - j));
        for( int k = 0; k < 4; k ++){
            dfs(i, j, x + d[k], y + d[k + 1], grid, m, n, island);
        }

        return true;
    }
}

// // | 711 | Number of Distinct Islands II |  Hard | Amazon |