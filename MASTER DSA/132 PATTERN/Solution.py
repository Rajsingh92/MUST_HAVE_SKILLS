class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        n = len(nums)

        minTo = []
        minTo.append(nums[0])

        for i in range(1, len(nums)):
            minTo.append(min(nums[i], minTo[i - 1]))

        stack = []

        for i in range(n - 1, 0, -1):
            while len(stack) > 0 and minTo[i] >= stack[-1]:
                stack.pop()

            if len(stack) > 0 and stack[-1] < nums[i]:
                return True

            stack.append(nums[i])

        return False
