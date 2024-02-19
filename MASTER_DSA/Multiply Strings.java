public class Solution {
    public String multiply(String num1, String num2) {

        // validation as to according to description, should also check length<110 and no leading zero
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        // @note: proof: 999 * 999 = (1000 - 1)^2 < 1000^2=1000000
        // i.e.: n1*n2 < 10^(len1+len2)  <=>  n1*n2 <= 999...99(length=len1+len2)
        int[] result = new int[num1.length() + num2.length()];

        // @note: reverse is better for store in results, or else reverse direction is annoying
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int carry = 0;
        int i = 0; // @note: for final check
        int j = 0; // @note: for final check
        for ( ; i < n1.length(); i++) {

            carry = 0; // @note: i missed this one, every out loop should update carry!
            int d1 = n1.charAt(i) - '0'; // digit of n1


            // for (; j < n2.length(); j++) { // @note: here j is not re-set to 0 in another i-loop
                                              //  that's why I like while() !!!
            for ( ; j < n2.length(); j++) {

                // first calculate this d1*n2
                int d2 = n2.charAt(j) - '0';

                int single = d1 * d2;
                int addCarry = single + carry;

                // add up to result array
                // i is also the indicator of start index in result array
                result[i + j] += addCarry;

                // @note: careful using if-else, and if carry<10 it's not updated
                // if (single >= 10) {
                //     carry += result[i + j] / 10;
                //     single = result[i + j] % 10;
                // }
                carry = result[i + j] / 10;
                result[i + j] = result[i + j] % 10;

            }

            // @note: outside inner loop, there should be a final check (not outside both for-loop)
            // eg.123*456
            if (carry > 0) { // j is ++ already
                result[i + j] = carry;
            }
        }

        // restore as string
        String m = "";
        for (i = 0; i < result.length; i++) {
            m = result[i] + m;
        }

        while (m.length() > 1 && m.charAt(0) == '0') {
            m = m.substring(1);
        }

        return m;
    }

    public String multiply2(String num1, String num2) {

        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);

        a = a.multiply(b);

        return a.toString();
    }
}


