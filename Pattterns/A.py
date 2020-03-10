for i in range(5):
    for j in range(4):
        if (j==0 or j==3) or (j>0 or j<0) and (i==0 or i==2):
            print("*",end=" ")
        else:
            print(" ",end=" ")
    print()
