
//  Longest Increasing Odd Even Subsequence


class Solution{
    public int longOddEvenIncSeq(int[] arr,int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 0;

        for(int i=1;i<n;i++){
            Integer max = null;

            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && arr[i]+arr[j]%2 != 0){
                    if(max == null || dp[j]>max){
                        max = dp[j];
                    }
                }
            }

            if(max!=null){
                dp[i] =max+1;
            }else{
                dp[i] = 1;
            }

            if(dp[i]>ans){
                ans = dp[i];
            }
        }

        return ans;
    }
}