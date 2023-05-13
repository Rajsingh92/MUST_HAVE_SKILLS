
class Solution {
    class Level {
        int maxlevel = 0;
    }

    Node result;

    public void deepestLeftLeafUtil(Node node, int lvl, Level level, boolean isLeft) {
        if (node == null)
            return;

        if (isLeft == true && node.left == null && node.right == null && lvl > level.maxlevel) {
            result = node;
            level.maxlevel = lvl;
        }

        deepestLeftLeafUtil(node.left, lvl + 1, level, true);
        deepestLeftLeafUtil(node.right, lvl + 1, level, false);
    }

    public void deepestLeftLeaf(Node node) {
        Level level = new Level();
        deepestLeftLeafUtil(node, 0, level, false);
    }
}
