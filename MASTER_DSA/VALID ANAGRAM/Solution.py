class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hashmap = {}

        for char in s:
            hashmap[char] = hashmap.get(char, 0) + 1

        for char in t:
            if char not in hashmap:
                return False

            if hashmap.get(char) == 1:
                del hashmap[char]
            else:
                hashmap[char] -= 1

        return len(hashmap) == 0
