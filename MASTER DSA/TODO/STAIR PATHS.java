import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printStairPaths(n, "");

        ArrayList<String> res = getStairPaths(n);
        System.out.print(res);
    }

    public static void printStairPaths(int n, String path) {
        if (n < 0)
            return;

        if (n == 0) {
            System.out.println(path);
            return;
        }

        printStairPaths(n - 1, path + 1);
        printStairPaths(n - 2, path + 2);
        printStairPaths(n - 3, path + 3);
    }

    public static ArrayList<String> getStairPaths(int n) {

        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> res1 = getStairPaths(n - 1);
        ArrayList<String> res2 = getStairPaths(n - 2);
        ArrayList<String> res3 = getStairPaths(n - 3);

        ArrayList<String> mres = new ArrayList<>();

        for (String res : res1) {
            mres.add(1 + res);
        }
        for (String res : res2) {
            mres.add(2 + res);
        }
        for (String res : res3) {
            mres.add(3 + res);
        }

        return mres;
    }
}
