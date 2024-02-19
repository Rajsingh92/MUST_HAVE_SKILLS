/**
Largest subarray with 0 sum 
Given an array having both positive and negative integers. The task is to compute the length of the 
largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
 */


public class Main {
    int maxLen(int arr[], int n)
    {
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();  //sum to index
        map.put(sum,-1);
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int len = i-map.get(sum);
                if(len>ans){
                    ans = len;
                }
            }
        }
        
        return ans;
    }
    
}   



/**
Zero Sum Subarrays / count subarray with zero sum
You are given an array A[] of size N. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
N = 6
A[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].
 */



public class Main {
    public static int findSubarray(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;

        map.put(sum, 1); // sum to freq

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum) == false) {
                map.put(sum, 1);
            } else {
                int freq = map.get(sum);
                ans += freq;
                map.put(sum, freq + 1);
            }
        }

        return ans;

    }
}

/**
Print all subarrays with 0 sum
Given an array, print all subarrays in the array which has sum 0.

Examples:

Input:  arr = [6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7]
Output:  
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6          
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10
 */



class Solution {

    public static void printAllSubarrayWith0Sum(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> firstal = new ArrayList();
        firstal.add(-1);
        map.put(0, firstal);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                ArrayList<Integer> al = map.get(sum);
                al.add(i);
                map.put(sum, al);
            } else {
                ArrayList<Integer> al = new ArrayList();
                al.add(i);
                map.put(sum, al);
            }

        }

        ArrayList<Integer> al = new ArrayList<>(map.keySet());
        Collections.sort(al);
        for (int key : al) {
            ArrayList<Integer> getal = map.get(key);
           
            for (int i = 0; i < getal.size(); i++) {
                for (int j = i + 1; j < getal.size(); j++) {
                    System.out.println(getal.get(i) + 1 + " " + getal.get(j));
                }
            }
        }

    }
}