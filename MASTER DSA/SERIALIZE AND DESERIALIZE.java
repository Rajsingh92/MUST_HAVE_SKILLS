/**
| 449 | Serialize and Deserialize BST |  Medium | Amazon, Facebook, Google, Microsoft |

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be 
stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized 
to a string and this string can be deserialized to the original tree structure.

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
 */

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }

        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);

        return root.val + "," + leftSerialize + "," + rightSerialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        LinkedList<String> queue = new LinkedList<>();

        for (String val : nodes) {
            queue.addLast(val);
        }

        return deserialize(queue);
    }

    public TreeNode deserialize(LinkedList<String> queue) {
        if (queue.size() == 0) {
            return null;
        }

        String peek = queue.removeFirst();
        if (peek.equals("X"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(peek));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;

    }

}


// | 428 | Serialize and Deserialize N-ary Tree |  Hard | Facebook |