import java.util.*;

public class Main {
    public static void completeTask(int n, int m, int[] arr) {
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        ArrayList < Integer > al1 = new ArrayList < > ();
        ArrayList < Integer > al2 = new ArrayList < > ();
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (counter % 2 == 0) {
                    al1.add(i);
                } else {
                    al2.add(i);
                }
                counter++;
            }
        }

        for (int a: al1) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int a: al2) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scn.nextInt();
        }
        completeTask(n, m, num);
    }

}