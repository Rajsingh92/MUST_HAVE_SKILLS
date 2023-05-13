class Solution {

    public static Node constructTree(char postfix[]) {
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < postfix.length; i++) {
            char ch = postfix[i];

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                Node newNode = new Node(ch);

                Node right = st.pop();
                Node left = st.pop();

                newNode.left = left;
                newNode.right = right;

                st.push(newNode);
            } else {
                Node newNode = new Node(ch);
                st.push(newNode);
            }
        }

        return st.peek();
    }

}