import java.util.*;

class Solution{
    public static void dfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] visited,Stack<Integer> st){
        visited[src] = true;

        for(int nbr : graph.get(src)){
            if(visited[nbr] == false){
                dfs(graph,nbr,visited,st);
            }
        }

        st.push(src);
    }

    public static void topologicalSort(ArrayList<ArrayList<Integer>> graph){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolen[graph.size()];

        for(int i = 0;i<graph.size();i++){
            if(visited[i] == false){
                dfs(graph,i,visited,st);
            }
        }

        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }
}