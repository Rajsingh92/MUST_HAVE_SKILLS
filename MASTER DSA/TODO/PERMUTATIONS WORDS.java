/**
Permutations - Words

1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 

aabb

output:

aabb
abab
abba
baab
baba
bbaa
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void generateWords(int cs, int ts, HashMap < Character, Integer > fmap, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (char ch: fmap.keySet()) {
            if (fmap.get(ch) > 0) {
                fmap.put(ch, fmap.get(ch) - 1);
                generateWords(cs + 1, ts, fmap, asf + ch);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
    }

    public static void generateWords(int cc, String str, Character[] spots,
        HashMap < Character, Integer > lastOccurence) {
        if (cc == str.length()) {
            for (char ch: spots) {
                System.out.print(ch);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);
        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                generateWords(cc + 1, str, spots, lastOccurence);
                lastOccurence.put(ch, lo);
                spots[i] = null;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap < Character, Integer > fmap = new HashMap < > ();
        for (char ch: str.toCharArray()) {
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        generateWords(1, str.length(), fmap, "");

        Character[] spots = new Character[str.length()];
        HashMap < Character, Integer > lastOccurence = new HashMap < > ();
        for (char ch: str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, spots, lastOccurence);
    }

}