/**
 * 
Longest subarray with sum divisible by K 
Given an array containing N integers and a positive integer K, find the length of the longest sub 
array with sum of the elements divisible by the given value K.

Example 1:

Input:
A[] = {2, 7, 6, 1, 4, 5}
K = 3
Output: 4
Explanation:The subarray is {7, 6, 1, 4}
with sum 18, which is divisible by 3.
 */




class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();   // rem to index
        int sum = 0;
        int ans = 0;
        map.put(0,-1);
        
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            int rem =  sum%k ;    // as the sum can be negative  taking modulo twice 

            if(rem<0){
                rem = rem+k;
            }

            if(map.containsKey(rem)==false){
                map.put(rem,i);
            }else{
                int len = i-map.get(rem);
                ans = Math.max(ans,len);
            }
            
            
        }
       return ans;
    }
 
}


/**
count subarray with sum divisible by k
 */


public class Main {

    public static int solution(int[] a, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();   // rem to freq
        int sum = 0;
        int ans = 0;
        map.put(0,1);
        
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            int rem =  sum%k ;    // as the sum can be negative  taking modulo twice 

            if(rem<0){
                rem = rem+k;
            }

            if(map.containsKey(rem)==false){
                map.put(rem,1);
            }else{
                int freq = map.get(rem);
                ans += freq;
                map.put(rem,freq+1);
            }
            
            
        }
       return ans;
    }
}