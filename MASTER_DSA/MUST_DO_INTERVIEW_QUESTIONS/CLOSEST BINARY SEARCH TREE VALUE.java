import java.util.*;

// Closest Binary Search Tree Value II |  Hard | Amazon Facebook ForUsAll Google LinkedIn |
class Closest_Binary_Search_Tree_Value_II {

    LinkedList<Integer> result = new LinkedList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inOrderTraversal(root, target, k);
        return result;
    }

    private void inOrderTraversal(TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, target, k);
        if (result.size() < k) {
            result.add(root.val);
        } else if (result.size() == k) { // hand-made priority queue
            if (Math.abs(result.getFirst() - target) > (Math.abs(root.val - target))) {
                result.removeFirst();
                result.addLast(root.val);
            } else {
                return; // diff is larger, so skip
            }
        }
        inOrderTraversal(root.right, target, k);
    }

}

// Closest Binary Search Tree Value | Easy | Amazon Bloomberg Facebook Google LinkedIn Microsoft Snapchat |
class Closest_Binary_Search_Tree_Value {

    public int closestValue(TreeNode root, double target) {

        TreeNode child = target < root.val ? root.left : root.right;

        if (child == null) {
            return root.val;
        }

        int childClosest = closestValue(child, target);

        return Math.abs(root.val - target) < Math.abs(childClosest - target) ? root.val : childClosest;
    }

}
