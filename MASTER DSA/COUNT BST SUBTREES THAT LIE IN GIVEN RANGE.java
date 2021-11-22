// count bst subtrees that lie in given range
class Solution {

    int count;

    public boolean getCountUtil(node root, int low, int high) {
        if (root == null)
            return true;

        boolean l = getCountUtil(root.left, low, high);
        boolean r = getCountUtil(root.right, low, high);

        if (l && r && root.data >= low && root.data <= high) {
            count++;
            return true;
        }

        return false;
    }

    public INT getCount(node root, int low, int high) {
        count = 0;
        getCountUtil(root, low, high, count);
        return count;
    }

}
