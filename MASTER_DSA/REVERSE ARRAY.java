
public class Solution{
    public static void reverse(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while(low<high){
            swap(arr,low,high);
            low++;
            high--;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void reverse(int[] arr, int i, int j) {
        while(i<j) {
            int temp=arr[i]^arr[j];
            arr[i]^=temp;
            arr[j]^=temp;
            i++;
            j--;
        }
    }
}