class Solution:
    def equilibriumPoint(self,A, N):
        if N == 1 :
            return 1
            
        sum = 0
        for a in A:
            sum += a
            
        left = 0
        for i in range(0,N):
            if left == sum - A[i] - left :
                return i+1
            
            left += A[i]
            
        return -1

