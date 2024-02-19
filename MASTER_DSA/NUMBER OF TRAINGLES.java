

public class Main {
 

    public static void coutnTraingle(int[][] adjMat ,int vtces, boolean isDirected){
        int count = 0;

        for(int i =0 ;i<vtces;i++){
            for(int j =0 ;j<vtces;j++){
                for(int k =0 ;k<vtces;k++){
                    if(adjMat[i][j] == 1 && adjMat[j][k] == 1) && adjMat[k][i]==1){
                        count++;
                    }
                }
            }
        }

        if(isDirected){
            ans = count/3;
            System.out.println(ans);
        }else{
            ans = count/6;
            System.out.println(ans);
        }
    }

}