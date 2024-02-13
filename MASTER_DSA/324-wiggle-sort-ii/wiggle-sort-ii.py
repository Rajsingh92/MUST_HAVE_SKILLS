class Solution:
    def wiggleSort_1(n: int, arr: List[int]) -> List[int]:
        # write your code here
        for i in range(1,n):

            if i%2 == 1 and arr[i]<arr[i-1]:
                arr[i],arr[i-1] = arr[i-1],arr[i]
            elif i%2 == 0 and arr[i]>arr[i-1]:
                arr[i],arr[i-1] = arr[i-1],arr[i]

        return arr

    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums.sort()
        ans = [0]*len(nums)

        j = len(nums)-1
        i=1

        while j >= 0 and i<len(nums):
            ans[i] = nums[j]
            j-=1
            i+=2

        i=0
        while j >= 0 and i<len(nums):
            ans[i] = nums[j]
            j-=1
            i+=2

        for i in range(len(nums)):
            nums[i] = ans[i]

        

        


        

        
                    

            

        