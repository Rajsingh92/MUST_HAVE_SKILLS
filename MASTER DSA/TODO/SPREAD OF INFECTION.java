

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class Pair{
       int v;
       int time;
       
       Pair(int v,int time){
           this.v = v;
           this.time = time;
       }
   }
   
   public static void countInfected(ArrayList<Edge>[] graph,int src,int t,int vtces){
       ArrayDeque<Pair> queue = new ArrayDeque<>();
       queue.add(new Pair(src,1));
       int[] visited = new int[vtces];
       int count = 0;
       
       while(queue.size()>0){
           Pair rem = queue.remove();
           
           if(visited[rem.v]>0){
               continue;
           }
           
           visited[rem.v] = rem.time;
           if(rem.time>t){
               break;
           }else{
               count++;
           }
           
           
           for(Edge e: graph[rem.v]){
               if(visited[e.nbr] == 0){
                   queue.add(new Pair(e.nbr,rem.time+1));
               }
           }
       }
       
       System.out.println(count);
   }

}