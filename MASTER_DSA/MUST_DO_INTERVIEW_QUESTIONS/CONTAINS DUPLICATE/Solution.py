

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s = set()
        
        for num in nums :
            if num in s :
                return True
            
            s.add(num)
            
        return False

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        d = dict()
        
        for i in range(0,len(nums)):
            if nums[i] in d:
                if abs(d[nums[i]] - i) <= k :
                    return True
                
            d[nums[i]] = i
            
        
        return False



    