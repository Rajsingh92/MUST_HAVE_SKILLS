class Solution:
    def pivotIndex(self, nums: List[int]) -> int:

        rightSum = [0]*len(nums)

        for i in range(len(nums)-2,-1,-1):
            rightSum[i] = nums[i+1]+rightSum[i+1]

        # print(rightSum)

        leftSum = 0
        for i in range(len(nums)):
            if leftSum == rightSum[i]:
                return i
            else:
                leftSum+=nums[i]

        return -1
        