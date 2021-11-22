/**
Reverse alternate levels of a perfect binary tree 

Given a complete binary tree, reverse the nodes present at alternate levels.

Example 1:

Input:
             1
          /   \
        3      2

Output:

             1
          /   \
        2      3

 */

class Tree {
    static void reverseAlternate(Node root) {
        boolean isOddLevel = false;
        LinkedList<Node> queue = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            LinkedList<Node> cQueue = new LinkedList<>();
            while (size-- > 0) {
                Node rem = queue.removeFirst();

                if (isOddLevel) {
                    cQueue.addLast(rem);
                    st.push(rem.data);
                }

                // last of this level
                if (size == 0) {
                    while (cQueue.size() > 0) {
                        Node front = cQueue.removeFirst();
                        front.data = st.pop();
                    }

                    isOddLevel = !isOddLevel;
                }

                if (rem.left != null) {
                    queue.addLast(rem.left);
                }

                if (rem.right != null) {
                    queue.addLast(rem.right);
                }
            }
        }
    }
}