
/**
K Length Words - 1

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
     word.


abcabc
2

ab
ac
ba
ca
bc
cb
 */

import java.util.*;

class Main {

    // // method 1
    public static void solve(String str/**str contains unique character */, int idx, int k, Character[] asf, int ssf) {

        if (ssf == k) {
            for (int i = 0; i < asf.length; i++) {
                System.out.print(asf[i]);
            }
            System.out.println();
            return;
        }

        if (idx == str.length()) {
            return;
        }

        // yes
        char ch = str.charAt(idx);
        for (int i = 0; i < k; i++) {
            if (asf[i] == null) {
                asf[i] = ch;
                solve(str, idx + 1, k, asf, ssf + 1);
                asf[i] = null;
            }
        }

        // no
        solve(str, idx + 1, k, asf, ssf);
    }

    // method 2
    public static void solve(String str,HashSet<Character> used ,Character[] asf,int idx) {
        if(idx == asf.length){
            for(int i=0;i<asf.length;i++){
                System.out.print(asf[i]);
            }
            System.out.println();
            return;
        }
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(used.contains(ch) == false){
                used.add(ch);
                asf[idx] = ch;
                solve(str,used,asf,idx+1);
                asf[idx] = null;
                used.remove(ch);
            }
        }
    }

}



/**
K Length Words - 2

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words by using chars of the word.

aaabb
3

aaa
aab
aba
abb
baa
bab
bba
 */

class Main {

    // // method 1
    public static void solve(int cs, int ts, String ustr, HashMap < Character, Integer > unique, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);

            if (unique.get(ch) > 0) {
                unique.put(ch, unique.get(ch) - 1);
                solve(cs + 1, ts, ustr, unique, asf + ch);
                unique.put(ch, unique.get(ch) + 1);
            }
        }
    }

    // // method 2
    public static void generateWords(int cc, String str, int ssf, int ts, Character[] spots,HashMap < Character, Integer > lastOccurence) {
        if (cc == str.length()) {
            if (ssf == ts) {
                for (char ch: spots) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);
        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                generateWords(cc + 1, str, ssf + 1, ts, spots, lastOccurence);
                lastOccurence.put(ch, lo);
                spots[i] = null;
            }
        }
        if (lastOccurence.get(ch) == -1) {
            generateWords(cc + 1, str, ssf + 0, ts, spots, lastOccurence);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        // HashMap < Character, Integer > unique = new HashMap < > ();
        // String ustr = "";
        // for (char ch: str.toCharArray()) {
        //     if (unique.containsKey(ch) == false) {
        //         unique.put(ch, 1);
        //         ustr += ch;
        //     } else {
        //         unique.put(ch, unique.get(ch) + 1);
        //     }
        // }

        //solve(1, k, ustr, unique, "");

        Character[] spots = new Character[k];
        HashMap < Character, Integer > lastOccurence = new HashMap < > ();
        for (char ch: str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, 0, k, spots, lastOccurence);
    }

}



/**
Words - K Selection - 1

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.

aabbbccdde
3

abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde
 */


class Main {
    // method 1
    public static void generateSelection(int i, String ustr, int ssf, int ts, String asf) {
        if (i == ustr.length()) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(i);
        generateSelection(i + 1, ustr, ssf + 1, ts, asf + ch);
        generateSelection(i + 1, ustr, ssf, ts, asf );
    }

    // method 2
    public static void generateSelection(String ustr, int cs, int ts, int lc, String asf) {  // lc : lastCount
        if(cs>ts){
            System.out.println(asf);
            return;
        }
        
        for(int i=lc+1;i<ustr.length();i++){
            generateSelection(ustr,cs+1,ts,i,asf+ustr.charAt(i));
        }
    }
}


/**
Words - K Selection - 2

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k characters out of the word.
 
aabbbccdde
3

aab
aac
aad
aae
abb
abc
abd
abe
acc
acd
ace
add
ade
bbb
bbc
bbd
bbe
bcc
bcd
bce
bdd
bde
ccd
cce
cdd
cde
dde
*/


class Main {

    // method 1
    public static void generateSelection(int cs, int ts, String ustr, HashMap < Character, Integer > unique, int ls, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (int i = ls; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);

            if (unique.get(ch) > 0) {
                unique.put(ch, unique.get(ch) - 1);
                generateSelection(cs + 1, ts, ustr, unique, i, asf + ch);
                unique.put(ch, unique.get(ch) + 1);
            }
        }
    }

    // method 2
    public static void generateSelection(int cc, String ustr, int ssf, int ts, HashMap < Character, Integer > unique, String asf) {
        if (cc == ustr.length()) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(cc);
        for (int i = unique.get(ch); i > 0; i--) {
            char[] fasf = new char[i];
            Arrays.fill(fasf, ch);
            generateSelection(cc + 1, ustr, ssf + i, ts, unique, asf + new String(fasf));
        }
        generateSelection(cc + 1, ustr, ssf + 0, ts, unique, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        // HashMap < Character, Integer > unique = new HashMap < > ();
        // String ustr = "";
        // for (char ch: str.toCharArray()) {
        //     if (unique.containsKey(ch) == false) {
        //         unique.put(ch, 1);
        //         ustr += ch;
        //     } else {
        //         unique.put(ch, unique.get(ch) + 1);
        //     }
        // }

        // generateSelection(1, k, ustr, unique, 0, "");


        HashMap < Character, Integer > unique = new HashMap < > ();
        String ustr = "";
        for (char ch: str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        generateSelection(0, ustr, 0, k, unique, "");
    }

}