class Solution {
    // N-ary Tree Postorder Traversal
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }

        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);

        return res;

    }

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node child : root.children) {
                stack.add(child);
            }
        }
        Collections.reverse(list);

        return list;

    }
}
