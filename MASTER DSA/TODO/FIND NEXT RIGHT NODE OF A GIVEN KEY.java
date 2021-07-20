
class Solution {

    public static Node findRightNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node front = queue.poll();

                if (front.key == val) {
                    if (size == 0) {
                        return null;
                    }
                    return queue.peek();
                }

                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }

        return null;
    }
}


