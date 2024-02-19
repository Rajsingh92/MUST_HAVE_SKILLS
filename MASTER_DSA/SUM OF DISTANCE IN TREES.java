/**
Sum of Distances in Tree |  Hard | Google | 

An undirected, connected tree with n nodes labelled 0...n-1 and n-1 edges are given.

The ith edge connects nodes edges[i][0] and edges[i][1] together.

Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

Example 1:

Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
 */


import java.util.*;
class Solution {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre)
                continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }

    public void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre)
                continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }

}