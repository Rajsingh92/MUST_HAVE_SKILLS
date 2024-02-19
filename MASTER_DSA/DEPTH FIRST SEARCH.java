
public class Main {

    public static void dfs1(ArrayList < Edge > [] graph,boolean[] visited,int v){
        visited[v] = true;
        System.out.println(v+" ");

        for(Edge e : graph[v]){
            if(!visited[e.nbr]){
                dfs1(graph,visited,e.nbr);
            }
        }
    }

    public static void dfs2(ArrayList < Edge > [] graph,boolean[] visited,int v){
        Stack < Pair > stack = new Stack < > ();
        stack.push(new Pair(v, v + ""));

        while (stack.size() > 0) {
            Pair rem = stack.pop();

            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);

            for (Edge e: graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    stack.push(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}