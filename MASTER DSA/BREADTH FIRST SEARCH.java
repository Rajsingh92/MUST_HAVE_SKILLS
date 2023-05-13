

public class Main {

    public static void bfs(ArrayList < Edge > [] graph,boolean[] visited,int v){
        ArrayDeque < Pair > queue = new ArrayDeque < > ();
        queue.add(new Pair(v, v + ""));

        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);

            for (Edge e: graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}