'''
Rotate Array |  Easy | Amazon |
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
'''



def reverse(arr,i,j):
    low = i
    high = j

    while low<high:
        arr[low],arr[high] = arr[high],arr[low]
        low+=1
        high-=1





def rightRotate(arr,k):
    n = len(arr)
    reverse(arr,0,n-k-1)
    reverse(arr,n-k,len(arr)-1)
    reverse(arr,0,len(arr)-1)

def rightRotateOneByOne(arr,k):
    for i in range(k):
        last = arr[len(arr)-1]
        for i in range(len(arr)-1,0,-1):
            arr[i] = arr[i-1]
        arr[0] = last

        






def leftRotate(arr,k):
    reverse(arr,0,k-1)
    reverse(arr,k,len(arr)-1)
    reverse(arr,0,len(arr)-1)


def leftrotateOneByOne(arr,k):
    for i in range(k):
        first = arr[0]
        for i in range(len(arr)-1):
            arr[i] = arr[i+1]

        arr[-1] = first



# inverse of an array
def inverse(arr):
    inv = []

    for i in range(0,len(arr)):
        val = arr[i]
        inv[val] = i
    
    return inv




        