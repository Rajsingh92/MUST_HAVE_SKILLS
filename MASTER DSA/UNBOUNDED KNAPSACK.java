/**
# unbounded knapsack
def unboundedKnapsack_DP1(val,wt,W,n):
    dp = [[0 for j in range(W+1)] for i in range(n+1)]

    for i in range(n+1):
        for j in range(W+1):
            if i==0 or j==0:
                dp[i][j]=0
            if wt[i-1]>j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j])  #small change

    print(dp[n][W])

def unboundedKnapsack_DP2(val,wt,W,n):
    dp = [ 0 for i in range(W+1)]
    dp[0] = 0

    for i in range(1,len(dp)):
        for j in range(n):
            if wt[j]<=i:
                dp[i] = max(dp[i],dp[i-wt[j]]+val[j])

    return dp[W]
 */