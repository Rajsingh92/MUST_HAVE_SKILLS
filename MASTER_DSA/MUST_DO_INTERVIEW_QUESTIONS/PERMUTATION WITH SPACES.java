// Permutation with Spaces	

class Solution {

    ArrayList<String> permutation(String str) {
        if (str.length() == 1) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add(str);
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = permutation(ros);
        ArrayList<String> mres = new ArrayList<>();

        for (String temp : rres) {
            mres.add(ch + temp);
            mres.add(ch + " " + temp);
        }

        return mres;
    }

}