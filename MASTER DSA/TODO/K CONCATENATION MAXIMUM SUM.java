/**
K-Concatenation Maximum Sum

Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its 
sum in that case is 0. 

Example 1:

Input: arr = [1,2], k = 3
Output: 9
 */



public class Main {

    public static long solution(int[] arr, int k, long sum) {
        if(k==1){
            return kadanesForOne(arr);
        }
        
        if(sum<0){
            return kadanesForTwo(arr);
        }else{
            return kadanesForTwo(arr)+(k-2)*sum;
        }
    }
    
     public static int kadanesForOne(int[] arr){
        int bestSum = arr[0];
        int currSum = arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(currSum>0){
                currSum+=arr[i];
            }else{
                currSum = arr[i];
            }
            
            bestSum = Math.max(bestSum,currSum);
        }
        
        return bestSum;
    }
    
    public static int kadanesForTwo(int[] arr){
        int[] narr = new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
            narr[i] = arr[i];
        }
        for(int i=0;i<arr.length;i++){
            narr[i+arr.length] = arr[i];
        }
        
        return kadanesForOne(narr);
    }

    public int kConcatenationMaxSum(int[] arr, int k) {       
        int mod=1000000007;
        int n=arr.length;
        long presum=0,premax=0,sufsum=0,sufmax=0,cursum=0,curmax=0;
        for(int i=0;i<n;i++){    
 
            // prefix sum
            presum+=arr[i];
            premax=Math.max(premax,presum);

            //suffix sum
            sufsum+=arr[n-1-i];
            sufmax=Math.max(sufmax,sufsum);
           
            //Kadane's Algorithm
            cursum=Math.max(0,cursum)+arr[i];
            curmax=Math.max(curmax,cursum);

        }
        long max=Math.max(curmax,premax+sufmax+Math.max(0,presum*(k-2))); 
        return (int)((k==1?curmax:max)%mod);
    }
}


