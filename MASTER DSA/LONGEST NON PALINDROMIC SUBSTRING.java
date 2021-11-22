// Source: https://www.geeksforgeeks.org/longest-non-palindromic-substring/

public class Solution {
    public boolean isPalindrome(String str) {
        int low = 0;
        int high = str.length() - 1;

        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    public int longestNonPalindromicSubstring(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return str.length();
        }

        // all characters are same
        boolean flag = false;
        char ch = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                flag = true;
                break;
            }
        }
        if (flag == false) { 
            return 0;
        }



        
        boolean res = isPalindrome(str);
        if (res == true) {
            return str.length() - 1;
        } else {
            return str.length();
        }
    }
}