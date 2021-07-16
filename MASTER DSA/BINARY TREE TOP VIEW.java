// Top View of a tree

public class Main {
    public static class pairVO {
        Node node; // actual Node
        int vl = 0; // vertical Level

        public pairVO(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    static int leftMinValue = 0;
    static int rightMaxValue = 0;

    public static void width(Node node, int lev) {
        if (node == null)
            return;

        leftMinValue = Math.min(leftMinValue, lev);
        rightMaxValue = Math.max(rightMaxValue, lev);

        width(node.left, lev - 1);
        width(node.right, lev + 1);
    }

    public static void topView(Node node) {
        width(node, 0);
        int[] ans = new int[rightMaxValue - leftMinValue + 1];
        Arrays.fill(ans, (int) -1e8);

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();

                if (ans[rpair.vl] == (int) -1e8)
                    ans[rpair.vl] = rpair.node.data;

                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 1));
            }
        }

        for (int ele : ans)
            System.out.println(ele);
        System.out.println();
    }
}