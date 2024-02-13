class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_dict = {}

        for i in range(len(nums)):
            nums_dict[nums[i]] = i

        print(nums_dict)

        for i in range(len(nums)):
            if  target-nums[i] in nums_dict and nums_dict[target-nums[i]] != i:
                return [i,nums_dict[target-nums[i]]]

