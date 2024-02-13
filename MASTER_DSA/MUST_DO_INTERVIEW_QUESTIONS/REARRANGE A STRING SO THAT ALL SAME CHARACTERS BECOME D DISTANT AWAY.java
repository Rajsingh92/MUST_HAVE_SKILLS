import java.util.*;

public class Solution {

	static class Pairs implements Comparable<Pairs> {
		char ch;
		int freq;

		Pairs(char c, int f) {
			ch = c;
			freq = f;
		}

		Pairs() {
		}

		public int compareTo(Pairs p) {
			return this.freq <= p.freq ? 1 : -1;
		}
	}

	public static void rearrange(String str, int d) {
		int[] f = new int[26];
		PriorityQueue<Pairs> pq = new PriorityQueue<Pairs>();
		for (int i = 0; i < str.length(); i++)
			f[str.charAt(i) - 'a']++;

		for (int i = 0; i < 26; i++) {
			if (f[i] != 0) {
				Pairs p = new Pairs((char) (i + 'a'), f[i]);
				pq.add(p);
			}
		}
		int n = str.length();
		int pos = 0;
		char[] ch = new char[n];
		while (!pq.isEmpty()) {
			Pairs temp = pq.poll();
			while (ch[pos] != '\u0000')
				pos++;
			if ((temp.freq - 1) * d + pos >= n) {
				System.out.println("Not possible");
				return;
			}
			for (int i = 0; i < temp.freq; i++) {
				ch[pos + i * d] = temp.ch;
			}

		}
		for (int i = 0; i < n; i++)
			System.out.print(ch[i]);
	}

}
