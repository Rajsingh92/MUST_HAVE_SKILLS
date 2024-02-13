class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:

        if len(ops) == 0:
            return m*n

        min_x = ops[0][0]
        min_y = ops[0][1]
        for i in range(len(ops)):
            min_x = min(min_x,ops[i][0])
            min_y = min(min_y,ops[i][1])

        return min_x*min_y

        