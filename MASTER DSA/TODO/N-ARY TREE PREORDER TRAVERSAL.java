class Solution {
    // N-ary Tree Preorder Traversal
    public List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for (Node node : root.children)
            preorder(node);

        return list;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
}
