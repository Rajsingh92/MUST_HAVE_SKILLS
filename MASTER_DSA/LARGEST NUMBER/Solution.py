class Compare(str):
    def __lt__(x, y):
        return x + y > y + x


class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        getSum = ''.join(sorted(map(str, nums), key=Compare))
        return '0' if getSum[0] == '0' else getSum
