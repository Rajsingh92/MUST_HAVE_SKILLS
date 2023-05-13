/*
Sum of dependencies in a graph 

Given a directed graph with V nodes and E edges. If there is an edge from u to v then u depends on v. Find out 
the sum of dependencies for every node. Duplicate edges should be counted as separate edges.

Example 1:

Input:
V=4
E=4
Edges={ {0,2},{0,3},{1,3},{2,3} }




Output:
4
Explanation:
For the graph in diagram, A depends
on C and D i.e. 2, B depends on D i.e.
1, C depends on D i.e. 1
and D depends on none.
Hence answer -> 0 + 1 + 1 + 2 = 4
*/

class Solution {

    public static int sumOfDependencies(Vector<Integer> adj[], int V) {
        int sum = 0;
        for (int u = 0; u < V; u++)
            sum += adj[u].size();

        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t-- > 0) {
            int V = scn.nextInt(), E = scn.nextInt();
            Vector<Integer> adj[] = new Vector[V];

            for (int i = 0; i < adj.length; i++) {
                adj[i] = new Vector<>();
            }

            for (int i = 0; i < E; i++) {
                adj[scn.nextInt()].addElement(scn.nextInt());
            }

            System.out.println(sumOfDependencies(adj, V));
        }

    }
}