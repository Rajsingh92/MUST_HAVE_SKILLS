
import java.util.*;

class Solution {

    public static int countNodes(TreeNode root) {
        int count = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode rem = queue.removeFirst();

            for (int i = 0; i < rem.child.size(); i++) {
                TreeNode children = rem.child.get(i);

                if (children.child.size() > rem.size())
                    count++;

                queue.add(children);
            }
        }

        return count;
    }
}
