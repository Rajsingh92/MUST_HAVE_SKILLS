class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        i = 0  # to iterated name 
        j = 0  # to iterate typed

        while i < len(name) and j < len(typed) :
            if name[i] == typed[j]:
                i+=1
                j+=1
            elif name[i] != typed[j] and j>0 and typed[j-1] == typed[j]:
                j+=1
            else :
                return False

        # if last character repeated 
        while j < len(typed) and typed[j-1] == typed[j]:
            j+=1
        
        if i != len(name) or j!= len(typed):
            return False

        return True
        