/**
Binary Subarrays With Sum
In an array A of 0s and 1s, how many non-empty subarrays have sum S?

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
 */

class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0,1); // sum to freq
        
        for(int i =0;i<A.length;i++){
            sum+=A[i];
            int val = sum - S;
            
            if(map.containsKey(val)){
                ans+=map.get(val);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}