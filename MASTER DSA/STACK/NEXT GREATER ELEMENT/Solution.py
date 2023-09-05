
#Leetcode 496
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)

        stack = []
        ans = [None]*n1
        nge = {}

        nge[nums2[n2-1]] = -1
        stack.append(nums2[n2-1])

        for i in range(n2-2,-1,-1):

            while len(stack) != 0 and stack[-1] <= nums2[i] :
                stack.pop()

            if len(stack) == 0:
                nge[nums2[i]] = -1
            else:
                nge[nums2[i]] = stack[-1]

            stack.append(nums2[i])

        # print(nge)
        

        for i in range(n1):
            ans[i] = nge[nums1[i]]

        print(ans)

        return ans
        
#Leetcode 503
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        n1 = len(nums)
        ans = [None]*n1

        nums = nums+nums
        n = len(nums)
        stack = []
        nge = [-1]*n
        

        stack.append(nums[n-1])

        for i in range(n-2,-1,-1):
            while len(stack) != 0 and stack[-1] <= nums[i]:
                stack.pop()

            if len(stack) != 0:
                nge[i] = stack[-1]

            stack.append(nums[i])
                
        for i in range(n1):
            ans[i] = nge[i]

        return ans




        


