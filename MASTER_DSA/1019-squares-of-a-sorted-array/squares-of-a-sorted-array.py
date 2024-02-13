class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = [0]*len(nums)


        left = 0
        right = len(nums)-1
        index = len(nums)-1

        while left<=right:
            # print(left,right)
            if abs(nums[left])>abs(nums[right]):
                res[index] = nums[left]*nums[left]
                left+=1
            else:
                res[index] = nums[right]*nums[right]
                right-=1

            index-=1

        return res
