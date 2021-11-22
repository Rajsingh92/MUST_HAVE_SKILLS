
class Solution {
    public static boolean check(Node root, int min, int max) {

        if (root == null) {
            return false;
        }

        if (min == max) {
            return true;
        }

        boolean left = check(root.left, min, root.data - 1);
        boolean right = check(root.right, root.data + 1, max);

        return left || right;
    }

    public static boolean isDeadEnd(Node root) {
        if (root == null) {
            return false;
        }

        return check(root, 1, Integer.MAX_VALUE);
    }
}