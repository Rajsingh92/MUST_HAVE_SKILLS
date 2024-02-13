class Main {

    public static int decimaltoanybase(int n, int b) {
        int num = 0;
        int p = 1;
        while (n > 0) {
            int rem = n % b;
            n = n / b;
            num += rem * p;
            p = p * 10;
        }

        return num;
    }

    public static int anybasetodecimal(int n, int b) {
        int num = 0;
        int p = 1;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            num += p * rem;
            p = p * b;
        }

        return num;
    }

    // any base addition
    public static int getSum(int b, int n1, int n2) {
        int rv = 0;

        int c = 0;
        int p = 1;
        while (n1 > 0 || n2 > 0 || c > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int d = d1 + d2 + c;
            c = d / b;
            d = d % b;

            rv += d * p;
            p = p * 10;
        }

        return rv;
    }

    // any base subtraction
    public static int getDifference(int b, int n1, int n2) {
        int rv = 0;

        int c = 0;
        int p = 1;
        while (n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int d = d2 - d1 - c;

            if (d < 0) {
                c = 1;
                d += b;
            } else {
                c = 0;
            }

            rv += d * p;
            p = p * 10;
        }

        return rv;
    }

    // any base multiplication
    public static int getProduct(int b, int n1, int n2) {
        int rv = 0;

        int c = 0;
        int p = 1;
        while (n2 > 0) {
            int d2 = n2 % 10;
            n2 = n2 / 10;

            int pwd = getProductWithDigit(b, n1, d2);
            rv = getSum(b, rv, p * pwd);
            p = p * 10;
        }

        return rv;
    }

    public static int getProductWithDigit(int b, int n1, int d2) {
        int rv = 0;

        int c = 0;
        int p = 1;
        while (n1 > 0 || c > 0) {
            int d1 = n1 % 10;
            n1 = n1 / 10;

            int d = d1 * d2 + c;
            c = d / b;
            d = d % b;

            rv += d * p;
            p = p * 10;
        }

        return rv;
    }

}