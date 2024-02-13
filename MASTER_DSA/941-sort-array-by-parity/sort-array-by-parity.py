class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        if len(nums) <=1 :
            return nums

        index = 0
        right = 0

        while right < len(nums) and nums[right]%2 == 0:
            right+=1
            index+=1

        while right < len(nums) :
            if nums[index]%2 !=0 and nums[right]%2 == 0:
                nums[index],nums[right] = nums[right],nums[index]
                index+=1

            right+=1
            
        return nums
