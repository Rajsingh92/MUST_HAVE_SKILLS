def findDuplicate(arr):
    repeated = []
    for i in range(len(arr)):
        k = i+1
        for k in range(k,len(arr)):
            if arr[i] == arr[k] and arr[i] not in repeated:
                repeated.append(arr[i])

    return repeated
list1 = [1,2,3,4,3,2]
print(findDuplicate(list1))