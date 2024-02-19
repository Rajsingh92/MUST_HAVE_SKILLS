import java.util.*;

public class Main {

    public static String shortestPalindrome(String str) {
        int low = 0;
        int high = str.length() - 1;
        int end = str.length() - 1;

        char[] charr = str.toCharArray();

        while (low < high) {
            if (charr[low] == charr[high]) {
                low++;
                high--;
            } else {
                low = 0;
                end--;
                high = end;
            }
        }

        String rem = new StringBuilder(str.substring(end + 1)).reverse().toString();
        return rem + str;
    }
}