class Solution {
    // it can be used for adding very large value by converting them into strings
    public String addStrings(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry + (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);

            int num = sum / 10;
            int rem = sum % 10;

            sb.insert(0, rem);
            carry = num;

            if (i >= 0) i--;
            if (j >= 0) j--;
        }

        return sb.toString();
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry + (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);

            int num = sum / 2;
            int rem = sum % 2;

            sb.insert(0, rem);
            carry = num;

            if (i >= 0) i--;
            if (j >= 0) j--;
        }

        return sb.toString();
    }
}






