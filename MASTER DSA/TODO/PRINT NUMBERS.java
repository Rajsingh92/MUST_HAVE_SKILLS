class Solution {
    public static void printIncreasing(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        printIncreasing(n - 1);
        System.out.println(n);

    }

    public static void printDecreasing(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void printIncreasingDecreasing(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printIncreasingDecreasing(n - 1);
        System.out.println(n);
    }

    // print zig zag
    public static void pzz(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
    }

    

}
