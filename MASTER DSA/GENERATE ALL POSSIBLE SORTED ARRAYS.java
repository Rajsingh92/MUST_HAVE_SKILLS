
class Solution {

    private static void solve(int[] arr1, int[] arr2, int i, int j, int[] res, int len, boolean flag) {
        if (flag && len != 0) {
            for (int k = 0; k < len; k++) {
                System.out.print(res[k] + " ");
            }
            System.out.println();
        }

        if (flag) {
            for (int indexforfirst = i; indexforfirst < arr1.length; indexforfirst++) {
                if (len == 0) {
                    res[len] = arr1[indexforfirst];
                    solve(arr1, arr2, indexforfirst + 1, j, res, len + 1, !flag);
                } else if (len > 0 && res[len - 1] < arr1[indexforfirst]) {
                    res[len] = arr1[indexforfirst];
                    solve(arr1, arr2, indexforfirst + 1, j, res, len + 1, !flag);
                }
            }
        } else {
            for (int indexforsecond = j; indexforsecond < arr2.length; indexforsecond++) {
                if (arr2[indexforsecond] > res[len - 1]) {
                    res[len] = arr2[indexforsecond];
                    solve(arr1, arr2, i, indexforsecond + 1, res, len + 1, !flag);
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr1 = new int[scn.nextInt()];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }

        int[] arr2 = new int[scn.nextInt()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }
        
        int[] C = new int[arr1.length + arr2.length];
        boolean flag = true; // true means element is to be taken from arr1 and vice versa
        solve(arr1, arr2, 0, 0, C, 0, flag);
    }
}
