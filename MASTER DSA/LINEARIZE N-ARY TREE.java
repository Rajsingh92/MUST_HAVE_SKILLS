class Solution {
    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node ip1 = node.children.remove(i + 1);
            Node itail = getTail(node.children.get(i));
            itail.children.add(ip1);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }

        return node;
    }

    public static Node linearize2(Node node) {
        if (node.children.size() == 0) {
            return node;
        }

        Node lkt = linearize2(node.children.get(node.children.size() - 1));

        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slkt = linearize2(sl);
            sl.children.add(last);
        }

        return lkt;
    }
}
