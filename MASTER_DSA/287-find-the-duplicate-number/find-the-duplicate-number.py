class Solution:
    def findDuplicate(self, nums: List[int]) -> int:

        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index] < 0:
                return abs(nums[i])

            nums[index] = -nums[index]

        return -1
        