class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        a1 = min(arr)  # float('-inf')
        an = max(arr)  # float('inf')

        d = (an - a1) / (len(arr) - 1)
        arr_set = set(arr)

        for i in range(0, len(arr)):
            T = a1 + i * d

            if T not in arr_set:
                return False

        return True
        