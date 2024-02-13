import java.util.*;

public class Solution {

    static int index;

    static void storeInorder(Node node, int inorder[]) {
        if (node == null)
            return;

        storeInorder(node.left, inorder);

        inorder[index] = node.data;
        index++;

        storeInorder(node.right, inorder);
    }

    static int countNodes(Node root) {
        if (root == null)
            return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static void arrayToBST(int[] arr, Node root) {
        if (root == null)
            return;

        arrayToBST(arr, root.left);

        root.data = arr[index];
        index++;

        arrayToBST(arr, root.right);
    }

    static void binaryTreeToBST(Node root) {

        if (root == null)
            return;
        int n = countNodes(root);
        int arr[] = new int[n];

        storeInorder(root, arr);
        Arrays.sort(arr);
        index = 0;
        arrayToBST(arr, root);
    }
}
