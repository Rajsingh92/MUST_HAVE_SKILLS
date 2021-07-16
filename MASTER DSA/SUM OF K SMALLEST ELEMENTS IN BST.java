/**
Sum of k smallest elements in BST 

Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.

Example 1:

Input: 
          20
        /    \
       8     22
     /    \
    4     12
         /    \
        10    14   , K=3

Output: 22
Explanation:
Sum of 3 smallest elements are: 
4 + 8 + 10 = 22
 */


class Solution {

    int count = 0;

    public int ksmallestElementSum(Node root, int k) {
        if (root == null)
            return 0;

        if (count > k)
            return 0;

        int leftSum = ksmallestElementSum(root.left, k);
        if (count >= k)
            return leftSum;

        leftSum += root.data;
        count++;

        if (count >= k)
            return leftSum;

        int rightSum = ksmallestElementSum(root.right, k);

        return leftSum + rightSum;
    }

    int sum(Node root, int k) {

        return ksmallestElementSum(root, k);
    }

}
