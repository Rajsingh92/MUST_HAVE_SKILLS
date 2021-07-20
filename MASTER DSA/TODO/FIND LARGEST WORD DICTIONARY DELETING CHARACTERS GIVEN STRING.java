// Source: https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/

import java.util.*;

class Solution {

	public static String getprob(ArrayList<String> arr, String str) {
		String result = "";
		int length = 0;

		for (String word : arr) {
			if (length < word.length() && isSubSequence(word, str, word.length(), str.length())) {
				result = word;
				length = word.length();
			}
		}

		return result;
	}

	static boolean isSubSequence(String str1, String str2, int m, int n) {
		int j = 0;

		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		return (j == m);
	}
}
