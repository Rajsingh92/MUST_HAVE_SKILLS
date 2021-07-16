// Arrange Buildings
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();

        long oldCountZero = 1;
        long oldCountOne = 1;

        for (int i = 2; i < n + 1; i++) {
            long newCountZero = oldCountOne;
            long newCountOne = oldCountZero + oldCountOne;

            oldCountZero = newCountZero;
            oldCountOne = newCountOne;
        }

        long ways = oldCountZero + oldCountOne;
        System.out.println(ways * ways);
    }
}
