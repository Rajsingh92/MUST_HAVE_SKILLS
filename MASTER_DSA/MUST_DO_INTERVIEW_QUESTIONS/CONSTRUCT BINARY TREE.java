public class Solution {
    // Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode constructFromPreIn(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return preInTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode preInTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei)
            return null;

        TreeNode node = new TreeNode(preorder[psi]);

        int idx = isi;
        while (inorder[idx] != preorder[psi])
            idx++;

        int tnel = idx - isi; // total no of elements.

        node.left = preInTree(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1);
        node.right = preInTree(preorder, psi + tnel + 1, pei, inorder, idx + 1, iei);

        return node;
    }

    // Construct Binary Tree from Inorder and levelorder
    public static TreeNode inLevelTree(int[] inorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }

        int index = start;
        for (int j = start + 1; j <= end; j++) {
            if (map.get(inorder[j]) < map.get(inorder[index])) {
                index = j;
            }
        }

        TreeNode root = new TreeNode(inorder[index]);
        root.left = inLevelTree(inorder, start, index - 1, map);
        root.right = inLevelTree(inorder, index + 1, end, map);

        return root;
    }

    public static TreeNode constructFromInLevel(int[] in, int[] level) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(level[i], i);
        }
        return inLevelTree(in, 0, in.length - 1, map);
    }

    // Construct Binary Tree from Inorder and Postorder | Medium | Microsoft |
    public TreeNode postInTree(int[] post, int psi, int pei, int[] in, int isi, int iei) {
        if (psi > pei)
            return null;

        TreeNode node = new TreeNode(post[pei]);
        int idx = isi;
        while (in[idx] != post[pei])
            idx++;

        int tnel = idx - isi;

        node.left = postInTree(post, psi, psi + tnel - 1, in, isi, idx - 1);
        node.right = postInTree(post, psi + tnel, pei - 1, in, idx + 1, iei);

        return node;
    }

    public TreeNode constructFromPostIn(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return postInTree(postorder, 0, n - 1, inorder, 0, n - 1);
    }

    // Construct Binary Tree from Preorder and Postorder Traversal | Medium |
    // Facebook, Google |
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = post.length;
        return postPreTree(post, 0, n - 1, pre, 0, n - 1);
    }

    public TreeNode postPreTree(int[] post, int ppsi, int ppei, int[] pre, int psi, int pei) {
        if (psi > pei)
            return null;

        TreeNode node = new TreeNode(pre[psi]);

        if (psi == pei)
            return node;

        int idx = ppsi;
        while (post[idx] != pre[psi + 1])
            idx++;

        int tnel = idx - ppsi + 1;
        node.left = postPreTree(post, ppsi, idx, pre, psi + 1, psi + tnel);
        node.right = postPreTree(post, idx + 1, ppei - 1, pre, psi + tnel + 1, pei);

        return node;
    }
}
