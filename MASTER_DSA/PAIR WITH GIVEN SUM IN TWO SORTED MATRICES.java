/**
Pairs With Given Sum In Two Sorted Matrices 
1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
2. You are also given a number X.
3. You have to find the count of all valid pairs from matrices whose sum is equal to X.

Input : mat1[][] = { {1, 5, 6},
                    {8, 10, 11},
                   {15, 16, 18} }
                         
    mat2[][] = { {2, 4, 7},
                 {9, 10, 12},
                 {13, 16, 20} }
       x = 21 
Output : 4
The pairs are:
(1, 20), (5, 16), (8, 13) and (11, 10).

 */


public class Main {
    public static int solve(int[][] num1, int[][] num2, int k) {
        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        int ans = 0;
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1[0].length; j++) {
                map.put(num1[i][j], map.getOrDefault(num1[i][j], 0) + 1);
            }
        }

        for (int i = 0; i < num2.length; i++) {
            for (int j = 0; j < num2[0].length; j++) {
                if (map.containsKey(k - num2[i][j])) {
                    ans += map.get(k - num2[i][j]);
                }
            }
        }
        return ans;
    }

    public static int solve2(int[][] num1, int[][] num2, int k) {
		
		int r1 = 0,c1 = 0;
		int r2 = num2.length-1,c2 = num2[0].length-1;
		int ans = 0;
		
		while(r1<num1.length && r2>=0){
		    int val = num1[r1][c1]+num2[r2][c2];
		    if(val == k){
		        ans++;
		        c1++;
		        c2--;
		        
		    }else if(val<k){
		        c1++;
		    }else{
		        c2--;
		    }
		    
		    
		    // reset to next row
		    if(c1 == num1.length){
		        c1 = 0;
		        r1++ ;
		    }
		    
		    if(c2 == -1){
		        c2 = num2[0].length-1;
		        r2--;
		    }
		}
		
		return ans;

		
	}
}


