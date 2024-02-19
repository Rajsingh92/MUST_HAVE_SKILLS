/**
Populating Next Right Pointers in Each Node |  Medium | Amazon, Facebook, Google, Microsoft |

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */


class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0) {
            int n = q.size();
            Node parent = new Node(-1);
            for (int i = 0; i < n; i++) {

                Node node = q.remove();
                parent.next = node;
                parent = node;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        
        return root;
    }
}

