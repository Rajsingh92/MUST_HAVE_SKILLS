/**
Max Sum Subarray of size K 
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

Example 1:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.
 */

 
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        if(K>N){
            return -1;
        }
        
        int ans = 0;
        int sum = 0;
        for(int i=0;i<K;i++){
            sum+=Arr.get(i);
            ans = sum;
        }
        
        for(int i = K;i<Arr.size();i++){
            sum = sum+Arr.get(i)-Arr.get(i-K);
            ans = Math.max(ans,sum);
        }
        
        return ans;
    }
}