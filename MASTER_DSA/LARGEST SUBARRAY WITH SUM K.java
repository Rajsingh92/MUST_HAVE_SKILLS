/** 
Longest Sub-Array with Sum K 
Given an array containing N integers and an integer K., Your task is to find the length of the 
longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
 */


class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>(); // sum to index
        int sum = 0;
        int ans = 0;
        map.put(0,-1);
        
        for(int i = 0;i<A.length;i++){
            sum+=A[i];
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }
            
            
            int val = sum-K;
            if(map.containsKey(val)){
                int len = i-map.get(val);
                ans = Math.max(ans,len);
            }
            
        }
        
        return ans;
    }
    
    
}