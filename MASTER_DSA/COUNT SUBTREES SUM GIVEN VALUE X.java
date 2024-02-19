
import java.io.*;

class Solution {
    static int count = 0;
    static Node ptr;

    int countSubtreesWithSum(Node root, int x) {
        int l = 0, r = 0;
        if (root == null)
            return 0;

        l += countSubtreesWithSum(root.left, x);
        r += countSubtreesWithSum(root.right, x);

        if (l + r + root.data == x)
            count++;

        if (ptr != root)
            return l + root.data + r;

        return count;
    }
}
