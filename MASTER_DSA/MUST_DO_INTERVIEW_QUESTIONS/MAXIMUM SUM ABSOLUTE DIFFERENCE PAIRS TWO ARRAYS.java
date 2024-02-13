/**
Minimum and Maximum sum of absolute differences of pairs
Given an array of N integers where N is even, find the minimum and maximum sum of absolute difference of N/2 
pairs formed by pairing every element with one other element.

Examples:

Input: a[] = {10, -10, 20, -40} 
Output: min_sum = 40, max_sum = 80
Explanation: Pairs selected for minimum sum 
             (-10, -40) and (10, 20) 
             min_sum = |-10 - -40| + |20 - 10| = 40 
             Pairs selected for maximum sum 
             (-10, 20) and (-40, 10) 
             max_sum = |-10 - 20| + |10 - -40| = 80
 */



class GFG {

    static void solve(int[] a, int n) {

        Arrays.sort(a);

        int min_sum = 0;
        int max_sum = 0;

        for (int i = 1; i < n; i += 2) {
            min_sum += Math.abs(a[i] - a[i - 1]);
        }
        
        for (int i = 0; i < n / 2; i++) {
            max_sum += Math.abs(a[n - 1 - i] - a[i]);
        }

        System.out.println("Min Sum:"+min_sum);
        System.out.println("Max Sum:"+max_sum);
    }
}


