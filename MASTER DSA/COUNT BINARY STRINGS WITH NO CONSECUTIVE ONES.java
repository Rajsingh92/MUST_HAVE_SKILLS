//count of binary string with no consecutive zeros

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int oldCountZero = 1;
        int oldCountOne = 1;

        for (int i = 2; i < n + 1; i++) {
            int newCountZero = oldCountOne;
            int newCountOne = oldCountZero + oldCountOne;

            oldCountZero = newCountZero;
            oldCountOne = newCountOne;
        }

        System.out.println(oldCountZero + oldCountOne);
    }
}


