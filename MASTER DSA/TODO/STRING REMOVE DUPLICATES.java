// Strings-Remove Duplicates
public class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String ans = str.charAt(0) + "";
        char prev = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (prev != ch) {
                ans += ch;
            }

            prev = ch;
        }

        System.out.println(ans);
    }
}