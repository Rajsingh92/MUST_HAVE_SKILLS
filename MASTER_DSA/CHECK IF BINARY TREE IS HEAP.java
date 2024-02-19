import java.util.*;

class Solution {
    static boolean isHeap(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean nullish = false;
        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            if (temp.left != null) {
                if (nullish || temp.left.data >= temp.data) {
                    return false;
                }
                q.add(temp.left);
            } else {
                nullish = true;
            }
            if (temp.right != null) {
                if (nullish || temp.right.data >= temp.data) {
                    return false;
                }
                q.add(temp.right);
            } else {
                nullish = true;
            }
        }
        return true;
    }
}
