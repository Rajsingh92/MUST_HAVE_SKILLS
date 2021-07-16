
class Solution {
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(node.data);
            return temp;
        }

        ArrayList<Integer> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node.data);
            return llist;
        }

        ArrayList<Integer> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node.data);
            return rlist;
        }
        return new ArrayList<>();
    }

    // n-ary tree
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }
}