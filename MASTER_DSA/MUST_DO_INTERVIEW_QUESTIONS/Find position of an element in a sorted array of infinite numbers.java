class Solution {
    public int search(int[] nums, int target) {
        return binarySearch2(nums,0,nums.length-1,target);
    }
    
    public int binarySearch(int[] arr, int ele) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) >> 1;

            if (arr[mid] == ele) {
                return mid;
            } else if (arr[mid] < ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return -1;
    }
    
    public int binarySearch2(int[] arr,int si,int hi,int ele){
        if(si>hi){
            return -1;
        }
        
        int mid = (si+hi)>>1;
        
        if (arr[mid] == ele) {
            return mid;
        }else if(arr[mid] < ele) {
            return binarySearch2(arr,mid+1,hi,ele);
        }else{
            return binarySearch2(arr,si,mid - 1,ele);
        }
    }

    // Find position of an element in a sorted array of infinite numbers
    public int findKeyInInfiniteSortedArray(int[] arr,int key){
        int low = 0;
        int high = 1;

        while(arr[high]<key){
            low = high;
            high = high*2;
        }

        return binarySearch2(arr,low,high,key);
    }
}
