/**
All Paths From Source to Target  | Amazon |

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */


class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graph, res, curr, 0, graph.length - 1);

        return res;
    }

    public void dfs(int[][] graph, List<List<Integer>> res, ArrayList<Integer> curr, int v, int dest) {

        if (v == dest) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int nbr : graph[v]) {
            curr.add(nbr);
            dfs(graph, res, curr, nbr, dest);
            curr.remove(curr.size() - 1);
        }

    }
}