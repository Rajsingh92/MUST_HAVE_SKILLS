import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        count = 0;
        printSets(arr, 0, target, 0, new ArrayList<>());
        System.out.print("\n");
        System.out.print(count);
    }

    static int count;

    public static void printSets(int[] arr, int idx, int target, int setSum, ArrayList<Integer> set) {

        if (idx == arr.length) {
            if (setSum == target) {
                for (int val : set) {
                    System.out.print(val + " ");
                }
                System.out.print(" ");
                count++;
            }
            return;
        }

        int val = arr[idx];
        // yes
        set.add(val);
        printSets(arr, idx + 1, target, setSum + val, set);
        set.remove(set.size() - 1);

        // no
        printSets(arr, idx + 1, target, setSum, set);
    }
}
