
// Program for transitive closure
// using Floyd Warshall Algorithm
import java.util.*;
import java.lang.*;
import java.io.*;

class GraphClosure {
    final static int V = 4; // Number of vertices in a graph

    // Prints transitive closure of graph[][] using Floyd
    // Warshall algorithm
    void transitiveClosure(int graph[][]) {
        /*
         * reach[][] will be the output matrix that will finally have the shortest
         * distances between every pair of vertices
         */
        int reach[][] = new int[V][V];
        int i, j, k;

        /*
         * Initialize the solution matrix same as input graph matrix. Or we can say the
         * initial values of shortest distances are based on shortest paths considering
         * no intermediate vertex.
         */
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                reach[i][j] = graph[i][j];

        /*
         * Add all vertices one by one to the set of intermediate vertices. ---> Before
         * start of a iteration, we have reachability values for all pairs of vertices
         * such that the reachability values consider only the vertices in set {0, 1, 2,
         * .. k-1} as intermediate vertices. ----> After the end of a iteration, vertex
         * no. k is added to the set of intermediate vertices and the set becomes {0, 1,
         * 2, .. k}
         */
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on a path from i to j,
                    // then make sure that the value of reach[i][j] is 1
                    reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(reach);
    }

    /* A utility function to print solution */
    void printSolution(int reach[][]) {
        System.out.println("Following matrix is transitive closure" + " of the given graph");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    System.out.print("1 ");
                else
                    System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {

        int graph[][] = new int[][] { { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };

        // Print the solution
        GraphClosure g = new GraphClosure();
        g.transitiveClosure(graph);
    }
}

// JAVA program to print transitive
// closure of a graph.

// A directed graph using
// adjacency list representation
public class Graph {

    // No. of vertices in graph
    private int vertices;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    // To store transitive closure
    private int[][] tc;

    // Constructor
    public Graph(int vertices) {

        // initialise vertex count
        this.vertices = vertices;
        this.tc = new int[this.vertices][this.vertices];

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {

        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {

        // Add v to u's list.
        adjList[u].add(v);
    }

    // The function to find transitive
    // closure. It uses
    // recursive DFSUtil()
    public void transitiveClosure() {

        // Call the recursive helper
        // function to print DFS
        // traversal starting from all
        // vertices one by one
        for (int i = 0; i < vertices; i++) {
            dfsUtil(i, i);
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println(Arrays.toString(tc[i]));
        }
    }

    // A recursive DFS traversal
    // function that finds
    // all reachable vertices for s
    private void dfsUtil(int s, int v) {

        // Mark reachability from
        // s to v as true.
        tc[s][v] = 1;

        // Find all the vertices reachable
        // through v
        for (int adj : adjList[v]) {
            if (tc[s][adj] == 0) {
                dfsUtil(s, adj);
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {

        // Create a graph given
        // in the above diagram
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " + "matrix is");

        g.transitiveClosure();

    }
}
