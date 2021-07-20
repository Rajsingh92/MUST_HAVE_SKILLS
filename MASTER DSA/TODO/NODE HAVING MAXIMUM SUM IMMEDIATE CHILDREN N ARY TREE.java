
import java.util.*;

class Solution {

    static int maxsum;
    static Node node;

    public static void helper(Node root) {
        if (root == null)
            return;

        int currsum = root.key;

        for (int i = 0; i < root.child.size(); i++) {
            currsum += root.child.get(i).key;
            helper(root.child.get(i));
        }

        if (currsum > maxsum) {
            node = root;
            maxsum = currsum;
        }

        return;
    }

    public static int maxSum(Node root) {
        int maxsum = 0;
        helper(root);
        return node.key;
    }

}
