import java.util.Scanner;

public class Main {


    static Node prev = null;

    public static void bToDLL_(Node root) {
        if (root == null)
            return;

        bToDLL_(root.left);

        prev.right = root;
        root.left = prev;

        prev = root;

        bToDLL_(root.right);
    }

    public static Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;
        bToDLL_(root);

        Node head = dummy.right;
        head.left = dummy.right = null;

        head.left = prev;
        prev.right = head;

        return head;
    }
}
