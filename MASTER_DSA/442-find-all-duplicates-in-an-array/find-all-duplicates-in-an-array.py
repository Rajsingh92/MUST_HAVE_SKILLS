class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        if len(nums) <= 1:
            return []

        result = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index] < 0:
                result.append(abs(nums[i]))

            nums[index] = -nums[index]

        return result

        