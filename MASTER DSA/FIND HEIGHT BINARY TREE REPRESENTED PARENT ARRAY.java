
class Solution {

    public void fillDepth(int parent[], int i, int depth[]) {
        if (depth[i] != 0) {
            return;
        }

        if (parent[i] == -1) {
            depth[i] = 1;
            return;
        }

        if (depth[parent[i]] == 0) {
            fillDepth(parent, parent[i], depth);
        }

        depth[i] = depth[parent[i]] + 1;
    }

    public int findHeight(int parent[], int n) {

        int depth[] = new int[n];
        for (int i = 0; i < n; i++) {
            fillDepth(parent, i, depth);
        }

        int ht = depth[0];
        for (int i = 1; i < n; i++) {
            if (ht < depth[i]) {
                ht = depth[i];
            }
        }

        return ht;
    }
}
