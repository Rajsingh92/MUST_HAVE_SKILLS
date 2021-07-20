/**
 * 
 1     2     3     4
 5     6     7     8
 9    10    11    12
 13    14    15    16
 17    18    19    20
 -------------------------------
1 
5 2 
9 6 3 
13 10 7 4 
17 14 11 8 
18 15 12 
19 16 
20


 */



public class Solution {
	public static void zigzagtraversal(int[][] arr){
	    //diagonals start with first row
	    for(int r = 0;r<arr.length;r++){
	        int i = r;
	        int j=  0;
	        while(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length){
	            System.out.print(arr[i][j]+" ");
	            i--;
	            j++;
	        }
	        System.out.println();
	    }
	    //diagonals start with last col
	    for(int c = 1;c<arr.length;c++){
	        int i = arr.length-1;
	        int j = c;
	        while(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length){
	            System.out.print(arr[i][j]+" ");
	            i--;
	            j++;
	        }
	        System.out.println();
	    }
	}
}