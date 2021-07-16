/**
Kth Largest Element in a Stream |  Easy | Amazon, Facebook, Google |
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Returns the element representing the kth largest element in the stream.
 */

import java.util.*;
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int K = 0;

    public KthLargest(int k, int[] nums) {
        this.K = k;
        for (int ele : nums) {
            pq.add(ele);
            if (pq.size() > k)
                pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > this.K)
            pq.remove();
        return pq.peek();
    }
}