/**
abc
-----------------
(a)(b)(c)
(a)(bc)
(ab)(c)
(abc)
 */

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// input string
		Scanner scn = new Scanner(System.in);
		String str = "abcd";
		printBracket(str, "");
	}

	public static void printBracket(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String cs = str.substring(0, i + 1);
			String ros = str.substring(i + 1);
			printBracket(ros, asf + "(" + cs + ")");
		}

	}

}