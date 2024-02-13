class Solution:
    def reverseVowels(self, s: str) -> str:
        s_list = list(s)

        vowels = ['a','e','i','o','u','A','E','I','O','U']

        i = 0
        j = len(s)-1

        while i <= j:
            char_a = s_list[i]
            char_b = s_list[j]

            if char_a not in vowels :
                if char_b not in vowels:
                    i+=1
                    j-=1
                else:
                    i+=1
            elif char_b not in vowels :
                if char_a not in vowels :
                    i+=1
                    j-=1
                else:
                    j-=1
            else:
                s_list[i],s_list[j] = s_list[j],s_list[i]
                i+=1
                j-=1


        return ''.join(s_list)
        