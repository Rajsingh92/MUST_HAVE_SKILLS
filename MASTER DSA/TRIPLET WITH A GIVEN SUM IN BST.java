import java.util.*;

// Node of the binary tree
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class GFG {
    static Node root;

    // Function that returns true if a pair exists
    // in the binary search tree with sum equal to x
    static boolean existsPair(Node root, int x) {

        // Iterators for BST
        Stack<Node> it1 = new Stack<Node>();
        Stack<Node> it2 = new Stack<Node>();

        // Initializing forward iterator
        Node c = root;
        while (c != null) {
            it1.push(c);
            c = c.left;
        }

        // Initializing backward iterator
        c = root;
        while (c != null) {
            it2.push(c);
            c = c.right;
        }

        // Two pointer technique
        while (it1.size() > 0 && it2.size() > 0) {

            // Variables to store values at
            // it1 and it2
            int v1 = it1.peek().data;
            int v2 = it2.peek().data;

            // Base case
            if (v1 + v2 == x) {
                return true;
            }
            if (v1 > v2) {
                break;
            }

            // Moving forward pointer
            if (v1 + v2 < x) {
                c = it1.peek().right;
                it1.pop();
                while (c != null) {
                    it1.push(c);
                    c = c.left;
                }
            }

            // Moving backward pointer
            else {
                c = it2.peek().left;
                it2.pop();
                while (c != null) {
                    it2.push(c);
                    c = c.right;
                }
            }
        }

        // Case when no pair is found
        return false;
    }

    // Function that returns true if a triplet exists
    // in the binary search tree with sum equal to x
    static boolean existsTriplet(Node root, Node curr, int x) {

        // If current node is NULL
        if (curr == null) {
            return false;
        }

        // Conditions for existence of a triplet
        return (existsPair(root, x - curr.data) || existsTriplet(root, curr.left, x)
                || existsTriplet(root, curr.right, x));
    }

    // Driver code
    public static void main(String[] args) {
        GFG tree = new GFG();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(8);
        int x = 24;
        if (existsTriplet(root, root, x)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}


