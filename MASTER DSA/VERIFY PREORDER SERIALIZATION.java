/**
Verify Preorder Serialization of a Binary Tree

One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. 
If it is a null node, we record using a sentinel value such as '#'.


For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.

Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid.

For example, it could never contain two consecutive commas, such as "1,,3".
 

Example 1:

Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
 */

public class Solution {
    public boolean isValidSerialization(String preorder) {

        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");

        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();

                if (st.size() == 0) {
                    return false;
                }

                st.pop();
            }
            st.push(curr);
        }

        return st.size() == 1 && st.peek().equals("#");
    }
}