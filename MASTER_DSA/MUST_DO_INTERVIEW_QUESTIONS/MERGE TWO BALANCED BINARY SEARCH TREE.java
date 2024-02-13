import java.util.*;

class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    public ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list) {
        if (node == null)
            return list;

        storeInorderUtil(node.left, list);
        list.add(node.data);
        storeInorderUtil(node.right, list);

        return list;
    }

    ArrayList<Integer> storeInorder(Node node) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = storeInorderUtil(node, list1);
        return list2;
    }

    ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {
        ArrayList<Integer> list3 = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        while (i < m) {
            list3.add(list1.get(i));
            i++;
        }

        while (j < n) {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }

    Node ALtoBST(ArrayList<Integer> list, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node node = new Node(list.get(mid));
        node.left = ALtoBST(list, start, mid - 1);
        node.right = ALtoBST(list, mid + 1, end);

        return node;
    }

    Node mergeTrees(Node node1, Node node2) {
        ArrayList<Integer> list1 = storeInorder(node1);
        ArrayList<Integer> list2 = storeInorder(node2);
        ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());
        Node node = ALtoBST(list3, 0, list3.size() - 1);
        return node;
    }
}
