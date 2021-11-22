

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
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void dijkstra(ArrayList < Edge > [] graph,int src){
        PriorityQueue < Pair > queue = new PriorityQueue < > ();
        queue.add(new Pair(src, src + "", 0));
        boolean[] visited = new boolean[vtces];
        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

            for (Edge e: graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }

    
}