def Naive(txt,pattern):
    m= len(txt)
    n= len(pattern)

    for i in range(m-n+1):
        j=0

        while(n>j):
            if (txt[i+j]!=pattern[j]):
                break
            j+=1
            if j==n:
                print("found at ",i)
   

print(Naive("AABAACAADAABAAABAA","AABA"))