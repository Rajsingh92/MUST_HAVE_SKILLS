class Solution {
    // N-ary Tree Level Order Traversal | Easy | Google |
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            while (size-- > 0) {
                Node rem = queue.removeFirst();
                temp.add(rem.val);

                for (Node ch : rem.children) {
                    queue.addLast(ch);
                }
            }

            res.add(temp);
        }

        return res;
    }
}


/**
public static void levelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (queue.size() > 0) {
            node = queue.remove();

            System.out.print(node.data + " ");

            for (Node child : node.children) {
                queue.add(child);
            }
        }

        System.out.println(".");
    }

    public static void levelOrderLinewise(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        Queue<Node> cqueue = new ArrayDeque<>();
        while (queue.size() > 0) {
            node = queue.remove();
            System.out.print(node.data + " ");

            for (Node child : node.children) {
                cqueue.add(child);
            }

            if (queue.size() == 0) {
                queue = cqueue;
                cqueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void levelOrderLinewiseZZ(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        Stack<Node> cstack = new Stack<>();
        int level = 0;

        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.data + " ");

            if (level % 2 == 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cstack.push(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cstack.push(child);
                }
            }

            if (stack.size() == 0) {
                stack = cstack;
                cstack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
 */

 