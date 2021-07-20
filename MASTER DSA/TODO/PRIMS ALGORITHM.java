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

   static class Pair implements Comparable < Pair > {
        Integer v;
        Integer pv;
        int wt;

        Pair(Integer v, Integer pv, int wt) {
            this.v = v;
            this.pv = pv;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
   
   public static void prims(ArrayList<Edge>[] graph,int vtces){
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       boolean[] visited = new boolean[vtces];
       pq.add(new Pair(0,-1,0));
       
       while(pq.size()>0){
           Pair rem = pq.remove();
           
           if(visited[rem.v]){
               continue;
           }
           visited[rem.v] = true;
           
           if (rem.pv != -1) {
                System.out.println("[" + rem.v + "-" + rem.pv + "@" + rem.wt + "]");
            }
           
           for(Edge e: graph[rem.v]){
               pq.add(new Pair(e.nbr,rem.v,e.wt));
           }
       }
   }

}