class Solution {
    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean res = false;
        for (Node child : root.childs) {
            res = res || rootToNodePath(child, data, ans);
        }

        if (res)
            ans.add(root);

        return res;
    }

    public static ArrayList<Node> rootToNodePath(Node root, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        rootToNodePath(root, data, ans);

        return ans;

    }

    public void kDown(Node root, Node blockNode, int time, List<List<Integer>> ans) {
        if (root == blockNode)
            return;

        if (ans.size() == time)
            ans.add(new ArrayList<>());

        ans.get(time).add(root.val);
        for (Node child : root.childs)
            kDown(child, blockNode, time + 1, ans);

    }

    // Method_01
    public List<List<Integer>> burningTree_01(Node root, int target) {
        ArrayList<Node> list = new ArrayList<>();
        rootToNodePath(root, target, list);

        List<List<Integer>> ans = new ArrayList<>();
        Node blockNode = null;

        for (int i = 0; i < list.size(); i++) {
            kDown(list.get(i), blockNode, i, ans);
            blockNode = list.get(i);
        }

        return ans;
    }

    // Method_02
    public int burningTree_02(Node root, int target, List<List<Integer>> ans) {
        if (root.val == target) {
            kDown(root, null, 0, ans);
            return 1;
        }

        int time = -1;
        Node blockNode = null;
        for (Node child : root.childs) {
            time = burningTree_02(child, target, ans);
            if (time != -1) {
                blockNode = child;
                break;
            }
        }

        if (time != -1) {
            kDown(root, blockNode, time, ans);
            time++;
        }
        return time;
    }
}
