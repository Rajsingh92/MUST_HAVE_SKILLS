/**
1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are 
     present in dictionary.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
 
ip:

11
i like pep coding pepper eating mango man go in pepcoding
ilikepeppereatingmangoinpepcoding

op:

i like pepper eating man go in pep coding 
i like pepper eating man go in pepcoding 
i like pepper eating mango in pep coding 
i like pepper eating mango in pepcoding 
 */


import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dict.add(scn.next());
        }
        String sentence = scn.next();
        wordBreak(sentence, "", dict);
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dict.contains(left)) {
                String right = str.substring(i + 1);
                wordBreak(right, ans + left + " ", dict);
            }
        }
    }

}





/**
import java.io.*;
import java.util.*;
// Word Break II |  Hard | Amazon, Apple, Facebook |
// Word Break |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet < String > dictionary = new HashSet < String > ();
        for (int i = 0; i < n; i++) {
            dictionary.add(scn.next());
        }
        String sentence = scn.next();
        System.out.println(solution(sentence, dictionary));
    }

    public static boolean solution(String sentence, HashSet < String > dictionary) {
        boolean[] dp = new boolean[sentence.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            char ch = sentence.charAt(i - 1);
            if (i == 1 && dictionary.contains(ch + "")) {
                dp[i] = true;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == true) {
                    String strtobechecked = sentence.substring(j, i);
                    if (dictionary.contains(strtobechecked)) {
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[dp.length - 1];
    }

    //leetcode 139.======================================================

	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> words=new HashSet(wordDict);
		int n=s.length();
		boolean[] dp=new boolean[n+1];
		
		int len=0;
		for(String word: wordDict) len=Math.max(len,word.length());
		
		dp[0]=true;
		for(int i=0;i<n;i++){
			if(!dp[i]) continue;
			
			for(int l=1;i+l<=n && l <= len ; l++){
				if(words.contains(s.substring(i,i+l))) dp[i+1]=true;
			}
		}

		return dp[n];
    }


    public void allLIS(ArrayList<ArrayList<Integer>> mapping, int[] arr, int idx, int len, String ans) {
        if (len == 1) {
            System.out.println(ans + arr[idx]);
            return;
        }

        for (Integer i : mapping.get(len - 1)) {
            if (i < idx && arr[i] < arr[idx]) {
                allLIS(mapping, arr, i, len - 1, ans + arr[idx] + ", ");
            }
        }
    }

    public void findAllLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            len = Math.max(len, dp[i]);
        }

        ArrayList<ArrayList<Integer>> mapping = new ArrayList<>();
        for (int i = 0; i <= len; i++)
            mapping.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            mapping.get(dp[i]).add(i);
        }

        for (Integer i : mapping.get(len)) {
            allLIS(mapping, arr, i, len, "");
        }
    }
}


	



// word break 2
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>(wordDict);
        return wordBreakHelper(s, 0, hs, hm);
    }

    private List<String> wordBreakHelper(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> hm) {

        if (hm.containsKey(start))
            return hm.get(start);

        List<String> validSubstr = new ArrayList<>();

        if (start == s.length())
            validSubstr.add("");

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (dict.contains(prefix)) {
                List<String> suffixes = wordBreakHelper(s, end, dict, hm);
                for (String suffix : suffixes)
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
            }
        }

        hm.put(start, validSubstr);
        return validSubstr;
    }
}

public class Q139 {
    //leetcode 139.======================================================

	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> words=new HashSet(wordDict);
		int n=s.length();
		boolean[] dp=new boolean[n+1];
		
		int len=0;
		for(String word: wordDict) len=Math.max(len,word.length());
		
		dp[0]=true;
		for(int i=0;i<n;i++){
			if(!dp[i]) continue;
			
			for(int l=1;i+l<=n && l <= len ; l++){
				if(words.contains(s.substring(i,i+l))) dp[i+1]=true;
			}
		}

		return dp[n];
    }
}


// A DP and Trie based program to test whether
// a given string can be segmented into
// space separated words in dictionary
import java.util.*;
import java.io.*;

class GFG {

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode children[];

        // isEndOfWord is true if the node
        // represents end of a word
        boolean isEndOfWord;

        // Constructor of TrieNode
        TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;

            isEndOfWord = false;
        }
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks leaf node
    static void insert(TrieNode root, String key) {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // Mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else
    // false
    static boolean search(TrieNode root, String key) {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    // Returns true if string can be segmented
    // into space separated words, otherwise
    // returns false
    static boolean wordBreak(String str, TrieNode root) {
        int size = str.length();

        // Base case
        if (size == 0)
            return true;

        // Try all prefixes of lengths from 1 to size
        for (int i = 1; i <= size; i++) {

            // The parameter for search is
            // str.substring(0, i)
            // str.substrinf(0, i) which is
            // prefix (of input string) of
            // length 'i'. We first check whether
            // current prefix is in dictionary.
            // Then we recursively check for remaining
            // string str.substr(i, size) which
            // is suffix of length size-i.
            if (search(root, str.substring(0, i)) && wordBreak(str.substring(i, size), root))
                return true;
        }

        // If we have tried all prefixes and none
        // of them worked
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        String dictionary[] = { "mobile", "samsung", "sam", "sung", "ma", "mango", "icecream", "and", "go", "i", "like",
                "ice", "cream" };

        int n = dictionary.length;
        TrieNode root = new TrieNode();

        // Construct trie
        for (int i = 0; i < n; i++)
            insert(root, dictionary[i]);

        System.out.print(wordBreak("ilikesamsung", root) ? "Yes\n" : "No\n");
        System.out.print(wordBreak("iiiiiiii", root) ? "Yes\n" : "No\n");
        System.out.print(wordBreak("", root) ? "Yes\n" : "No\n");
        System.out.print(wordBreak("ilikelikeimangoiii", root) ? "Yes\n" : "No\n");
        System.out.print(wordBreak("samsungandmango", root) ? "Yes\n" : "No\n");
        System.out.print(wordBreak("samsungandmangok", root) ? "Yes\n" : "No\n");
    }
}


 */