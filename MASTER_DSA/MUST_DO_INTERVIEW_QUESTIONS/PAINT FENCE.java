// paint fence
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        // start 2
        long same = k;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }

        System.out.println(total);
    }
}
