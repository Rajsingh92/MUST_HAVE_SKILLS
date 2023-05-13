/**
Length of the largest subarray with contiguous elements 
Given an array of integers, find length of the longest subarray which contains numbers that can be arranged 
in a continuous sequence.
In the previous post, we have discussed a solution that assumes that elements in given array are distinct. 
Here we discuss a solution that works even if the input array has duplicates.

Examples:

Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {10, 12, 12, 10, 10, 11, 10};
Output: Length of the longest contiguous subarray is 2 
 */


public class Main {
    // with duplicate
    public static int solution(int[] arr) {
        int ans = 0;
        for(int i = 0;i<arr.length-1;i++){
            HashSet<Integer> cd = new HashSet<>();
            cd.add(arr[i]);
            
            int min = arr[i];
            int max = arr[i];
            
            for(int j=i+1;j<arr.length;j++){
                if(cd.contains(arr[j])){
                    break;
                }
                cd.add(arr[j]);
                
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);
                
                if(max-min == j-i){
                    int len = j-i+1;
                    ans = Math.max(ans,len);
                }
            }
        }
        
        return ans;
    }

    // without duplicate
    public static int solve2(int[] arr){
        int len = 0;
        int n = arr.length;

        int min = 0, max = 0;
        for(int i=0;i < n;i++){
            min = max = arr[i];

            for(int j = i+1;j<n;j++){
                min = Math.min(min,arr[j]);
                max = Math.max(max,arr[j]);

                if(max - min == j - i) len = Math.max(len, j - i);
            }
        }

        return len;
    }

}