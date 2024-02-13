/**
Print a Binary Tree in Vertical Order

           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
 */

import java.util.*;

class Main {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class verticalPair {
        TreeNode node = null;
        int hl = 0; // horizontal Level

        verticalPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        LinkedList<verticalPair> que = new LinkedList<>();
        que.addLast(new verticalPair(root, 0));
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int minHL = 0;
        int maxHL = 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                map.putIfAbsent(rp.hl, new ArrayList<>());
                map.get(rp.hl).add(rp.node.val);

                minHL = Math.min(minHL, rp.hl);
                maxHL = Math.max(maxHL, rp.hl);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left, rp.hl - 1));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (minHL <= maxHL) {
            ans.add(map.get(minHL));
            minHL++;
        }

        return ans;
    }

    // ans = {minHl,maxHL}
    public static void width(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);

        width(root.left, hl - 1, ans);
        width(root.right, hl + 1, ans);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode root) {
        PriorityQueue<verticalPair> que = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val; // this - other for default behaviour
        });
        PriorityQueue<verticalPair> childQue = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++)
            ans.add(new ArrayList<>());

        que.add(new verticalPair(root, -minMax[0]));

        while (que.size() != 0) {
            verticalPair rp = que.remove();

            ans.get(rp.hl).add(rp.node.val);

            if (rp.node.left != null)
                childQue.add(new verticalPair(rp.node.left, rp.hl - 1));

            if (rp.node.right != null)
                childQue.add(new verticalPair(rp.node.right, rp.hl + 1));

            if (que.size() == 0) {
                PriorityQueue<verticalPair> temp = que;
                que = childQue;
                childQue = temp;
            }
        }

        return ans;

    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        LinkedList<verticalPair> que = new LinkedList<>();

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++)
            ans.add(0);

        que.addLast(new verticalPair(root, -minMax[0]));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                ans.set(rp.hl, ans.get(rp.hl) + rp.node.val);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left, rp.hl - 1));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
            }
        }

        return ans;
    }
}
