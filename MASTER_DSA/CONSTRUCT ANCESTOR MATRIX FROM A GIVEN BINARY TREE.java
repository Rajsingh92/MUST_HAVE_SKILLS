

public class Solution {

    public void constructAncestorMatrix(Node root, int[][] mat) {

        if (root == null)
            return;

        constructAncestorMatrix(root.left, mat);
        constructAncestorMatrix(root.right, mat);

        if (root.left != null) {
            mat[root.data][root.left.data] = 1;

            for (int i = 0; i < mat.length; i++) {
                if (mat[root.left.data][i] == 1) {
                    mat[root.data][i] = 1;
                }
            }
        }

        if (root.right != null) {
            mat[root.data][root.right.data] = 1;

            for (int i = 0; i < mat.length; i++) {
                if (mat[root.right.data][i] == 1) {
                    mat[root.data][i] = 1;
                }
            }
        }

    }
}


// Construct Tree From Ancestor Matrix