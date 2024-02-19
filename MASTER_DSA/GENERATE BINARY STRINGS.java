// Generate Binary Strings
public class Main {

    public static void solve(String str, String out, int pos, ArrayList<String> res) {
        if (pos == str.length()) {
            res.add(out);
            return;
        }

        char ch = str.charAt(pos);
        if (ch == '?') {
            solve(str, out + '0', pos + 1, res);
            solve(str, out + '1', pos + 1, res);
        } else {
            solve(str, out + ch, pos + 1, res);
        }
    }

}

class solution {
    static void generateAllBinaryStrings(int n, int arr[], int i) {
        if (i == n) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1);

        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1);
    }
}