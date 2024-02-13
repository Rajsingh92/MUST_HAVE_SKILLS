/**
Diagonal Traversal of Binary Tree 
Given a Binary Tree, print the diagonal traversal of the binary tree.
Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree 
belonging to same line.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
 */


public class Main {

    public static class pairVO {
        Node node; // actual Node
        int vl = 0; // vertical Level

        public pairVO(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    static int leftDMinValue = 0;

    public static void widthDiagonal(Node node, int lev) {
        if (node == null)
            return;

        leftMinValue = Math.min(leftMinValue, lev);

        width(node.left, lev - 1);
        width(node.right, lev + 0);
    }

    public static void diagonalOrder(Node node) {
        widthDiagonal(node, 0);
        int n = -leftDMinValue + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ans.add(new ArrayList<>());

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans.get(rpair.vl).add(rpair.node.data);
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 0));
            }
        }

        for (ArrayList<Integer> ar : ans)
            System.out.println(ar);
        System.out.println();
    }

    public static void diagonalSum(Node node) {
        widthDiagonal(node, 0);
        int n = -leftDMinValue + 1;
        int[] ans = new int[n];

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans[rpair.vl] += rpair.node.data;
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 0));
            }
        }

        for (int ele : ans)
            System.out.println(ele);
        System.out.println();
    }
}