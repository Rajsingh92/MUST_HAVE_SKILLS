import java.util.Stack;

class Soltuion {
    public static void reverseWords1(String str) {
        Stack<Character> st = new Stack<>(); // O(n) space
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                while (st.size() > 0) {
                    System.out.print(st.pop() + " ");
                }
            } else {
                st.push(ch);
            }
        }
        while (st.size() > 0) {
            System.out.print(st.pop() + " ");
        }
    }

    // optimized
    public static void reverseWords2(String str) {
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ' || ch == str.length() - 1) {
                int end;
                if (i == str.length() - 1)
                    end = i;
                else
                    end = i - 1;

                while (start < end) {
                    swap(str, start, end);
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }

    }

    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
