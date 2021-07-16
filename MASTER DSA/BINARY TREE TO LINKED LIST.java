/**
Flatten Binary Tree to Linked List |  Medium | Adobe, Amazon, Microsoft |

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the 
list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (st.size() > 0) {
            TreeNode rem = st.pop();

            if (rem.right != null)
                st.push(rem.right);
            if (rem.left != null)
                st.push(rem.left);

            if (st.size() > 0)
                rem.right = st.peek();

            rem.left = null;
        }
    }
}


/**
Binary Tree to DLL 

Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in 
nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in 
DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (leftmost node in 
BT) must be the head node of the DLL.


Example 1:

Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3 
Explanation: DLL would be 3<=>1<=>2
 */


class Solution {

    class Wrapper {
        public Node node;

        Wrapper(Node node) {
            this.node = node;
        }
    }

    Node bToDLL(Node root) {
        return convert(root, root, new Wrapper(null));
    }

    public Node convert(Node curr, Node head, Wrapper prev) {
        if (curr == null) {
            return head;
        }

        head = convert(curr.left, head, prev);

        if (prev.node != null) {
            curr.left = prev.node;
            prev.node.right = curr;
        } else {
            head = curr;
        }

        prev.node = curr;

        return convert(curr.right, head, prev);
    }
}





