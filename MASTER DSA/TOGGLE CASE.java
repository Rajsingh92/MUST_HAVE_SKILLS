public class Solution {
    public String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch - 'a' + 'A'));
            } else {
                sb.append((char) (ch - 'A' + 'a'));
            }
        }

        return sb.toString();
    }
}

//  To Lower Case | Easy | Adobe, Amazon, Apple |
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public String toLowerCase2(String str) {
        char[] a = str.toCharArray();

        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');

        return new String(a);
    }
}

// Strings-Toggle Case
public class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int input = ch;

            if (input >= 65 && input <= 90) {
                input += 32;
                char te = (char) input;
                ans += te;
            } else {
                input -= 32;
                char te = (char) input;
                ans += te;
            }
        }

        System.out.println(ans);
    }
}