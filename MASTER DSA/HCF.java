public class HCF {

    public static void hcf(int n1, int n2) {
        int min = Math.min(n1, n2);

        int hcf = 1;

        int count = 1;
        while (count <= min) {

            if (n1 % count == 0 && n2 % count == 0) {
                hcf = count;
            }

            count = count + 1;
        }

        System.out.println(hcf);
    }

    public static void hcf2(int n1, int n2) {
        int divident = scn.nextInt();
        int divisor = scn.nextInt();

        while (true) {

            int rem = divident % divisor;

            if (rem == 0)
                break;

            divident = divisor;
            divisor = rem;

        }

        System.out.println(divisor);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
