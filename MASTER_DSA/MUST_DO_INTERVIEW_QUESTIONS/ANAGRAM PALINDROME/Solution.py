class Solution:
    def isPossible(self, S):
        dict1 = {}

        for char in S:
            dict1[char] = dict1.get(char, 0) + 1

        countInvalid = 0
        for key in dict1.keys():
            freq = dict1.get(key)

            if freq % 2 != 0:
                countInvalid += 1
        
        return 1 if countInvalid <= 1 else 0

