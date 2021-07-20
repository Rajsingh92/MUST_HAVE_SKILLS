import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }


    public static int hamintonianPath(int src,int osrc,boolean[] vis,int edgeCount,String psf){
        if(edgeCount == N - 1){
            psf += src;
            int idx = searchVtx(src,osrc);
            
            if(idx != -1) System.out.println("Cycle : " + psf);
            else  System.out.println("Path : " + psf);

            return 1;
        }

        vis[src] = true;
        int count = 0;
        for(Edge e: graph[src]){
            if(!vis[e.v])
              count += hamintonianPath(e.v,osrc,vis,edgeCount + 1,psf + src + " "); 
        }

        vis[src] = false;
        return count;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());

        HashSet < Integer > visited = new HashSet < > ();
        hamiltonianPathAndCycle(graph, src, src, visited, src + "");
    }

    public static void hamiltonianPathAndCycle(ArrayList < Edge > [] graph, int osrc, int src, HashSet < Integer > visited, String psf) {
        if (visited.size() == graph.length - 1) {
            System.out.print(psf);

            boolean closingEdge = false;
            for (Edge e: graph[osrc]) {
                if (e.nbr == src) {
                    closingEdge = true;
                    break;
                }
            }

            if (closingEdge) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }

        visited.add(src);
        for (Edge e: graph[src]) {
            if (!visited.contains(e.nbr)) {
                hamiltonianPathAndCycle(graph, osrc, e.nbr, visited, psf + e.nbr);
            }
        }
        visited.remove(src);
    }

}