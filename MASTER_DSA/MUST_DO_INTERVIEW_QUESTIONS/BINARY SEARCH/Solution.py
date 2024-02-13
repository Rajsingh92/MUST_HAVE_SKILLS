class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        
        return self.binary_search_rec(nums, low, high, target)
    
    def binary_search_it(self, nums, low, high, target):
        
        while low <= high :
            mid  =  (low + high) // 2
            
            if nums[mid] == target :
                return  mid
            elif nums[mid] > target :
                high = mid - 1
            else:
                low = mid + 1
                
        return -1
    
    def binary_search_rec(self, nums, low, high, target):
        if low > high :
            return -1
        
        mid = (low + high) // 2
        
        if nums[mid] == target :
            return mid
        elif nums[mid] > target:
            return self.binary_search_rec(nums, low, mid-1, target)
        else:
            return self.binary_search_rec(nums, mid + 1, high, target)
        
        
        
    
    
    