//  Count number of trees in a forest


public class Main {

    public static void dfs(ArrayList < Edge > [] graph,boolean[] visited,int v){
        visited[v] = true;

        for(Edge e : graph[v]){
            if(!visited[e.nbr]){
                dfs(graph,visited,e.nbr);
            }
        }
    }


    public static void countTrees(ArrayList < Edge > [] graph,int vtces){
        boolean[] visited = new boolean[vtces];
        int ans = 0;

        for(int v =0;v<vtces;v++){
            if(visited[v] == false){
                dfs(graph,visited,v);
                res++;
            }
        }

        System.out.println(res);
    }


}