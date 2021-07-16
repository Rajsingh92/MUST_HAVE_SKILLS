import java.io.*;

class mColoringProblem {
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t_i = 0 ; t_i < T ; t_i++){
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    int[][] graph = new int[N][N];
		    int E = sc.nextInt();
		    for(int e_i = 0 ; e_i < E ; e_i++){
		        int x = sc.nextInt()-1;
		        int y = sc.nextInt()-1;
		        graph[x][y] = 1;
		        graph[y][x] = 1;
		    }
		    if(graphColoring(graph,M,N)){
		        System.out.println(1);
		    }else{
		        System.out.println(0);
		    }
		}
	}
	
	static boolean graphColoring(int[][] graph, int m, int V){
	    int[] color = new int[V];
	    for(int c_i = 0; c_i < V ; c_i++){
	        color[c_i] = 0;
	    }
	    
	    return graphColoringUtil(graph, color, m, 0,V);
	    
	}
	
	static boolean graphColoringUtil(int[][] graph, int[] color, int m , int v, int V){
	    
	    if(v==V) return true;
	    
	    for(int c_i = 1 ; c_i <= m ; c_i++){
	        if(isSafe(v,graph,color,c_i,V)){
	            color[v]=c_i;
	            if(graphColoringUtil(graph, color, m, v+1,V)){
	                return true;
	            }
	            color[v]=0;
	        }
	    }
	    
	    return false;
	    
	}
	
	static boolean isSafe(int v, int[][] graph , int[] color, int c, int V){
	    for(int i = 0; i < V ; i++){
	        if(graph[v][i]==1&&c==color[i]){
	            return false;
	        }
	    }
	    
	    return true;
	}
}