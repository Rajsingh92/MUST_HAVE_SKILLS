class Solution {

    static int count;

    int dupSub(Node root) {
        HashMap<String, Integer> map = new HashMap<>();
        count = 0;
        serialize(root, map);
        return count;
    }

    public String serialize(Node root, HashMap<String, Integer> map) {
        if (root == null) {
            return "";
        }

        String leftSerialize = serialize(root.left, map);
        String rightSerialize = serialize(root.right, map);

        String str = "(" + leftSerialize + root.data + rightSerialize + ")";

        if (map.containsKey(str) && str.length() > 4) {
            System.out.print(str + " ");
            count++;
        }

        map.put(str, map.getOrDefault(str, 0) + 1);

        return str;
    }
}