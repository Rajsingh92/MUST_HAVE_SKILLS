// Get Subsequence Of String

public class Solution {

    public static ArrayList<String> getSubsequence(String str) {

        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0); // a
        String ros = str.substring(1); // bc
        ArrayList<String> rres = getSubsequence(ros);

        ArrayList<String> res = new ArrayList<>();

        for (String s : rres) {
            res.add("" + s);
        }
        for (String s : rres) {
            res.add(ch + s);
        }

        return res;
    }
}