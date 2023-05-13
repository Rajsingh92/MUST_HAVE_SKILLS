
// Java program for the above approach
import java.io.*;

class GFG {

    // Function to check if the weights
    // can be delivered in D days or not
    static boolean isValid(int[] weight, int n, int D, int mx) {

        // Stores the count of days required
        // to ship all the weights if the
        // maximum capacity is mx
        int st = 1;
        int sum = 0;

        // Traverse all the weights
        for (int i = 0; i < n; i++) {
            sum += weight[i];

            // If total weight is more than
            // the maximum capacity
            if (sum > mx) {
                st++;
                sum = weight[i];
            }

            // If days are more than D,
            // then return false
            if (st > D)
                return false;
        }

        // Return true for the days < D
        return true;
    }

    // Function to find the least weight
    // capacity of a boat to ship all the
    // weights within D days
    static void shipWithinDays(int[] weight, int D, int n) {

        // Stores the total weights to
        // be shipped
        int sum = 0;

        // Find the sum of weights
        for (int i = 0; i < n; i++)
            sum += weight[i];

        // Stores the maximum weight in the
        // array that has to be shipped
        int s = weight[0];
        for (int i = 1; i < n; i++) {
            s = Math.max(s, weight[i]);
        }

        // Store the ending value for
        // the search space
        int e = sum;

        // Store the required result
        int res = -1;

        // Perform binary search
        while (s <= e) {

            // Store the middle value
            int mid = s + (e - s) / 2;

            // If mid can be shipped, then
            // update the result and end
            // value of the search space
            if (isValid(weight, n, D, mid)) {
                res = mid;
                e = mid - 1;
            }

            // Search for minimum value
            // in the right part
            else
                s = mid + 1;
        }

        // Print the result
        System.out.println(res);
    }

    // Driver Code
    public static void main(String[] args) {

        int[] weight = { 9, 8, 10 };
        int D = 3;
        int N = weight.length;

        shipWithinDays(weight, D, N);
    }
}

// This code is contributed by Dharanendra L V.
