public class Reverse_Words_in_a_String {

	// basically, 1st scan to reverse whole string including space,
    // 2nd scan to reverse each word when encountering a space
	public class Solution_2Scan {
		public String reverseWords(String s) {

			if (s == null || s.length() == 0) {
				return s;
			}

            int storeIndex = 0, n = s.length();
            StringBuilder sb = new StringBuilder(s).reverse();
            for (int i = 0; i < n; ++i) {
                if (sb.charAt(i) != ' ') {
                    if (storeIndex != 0) sb.setCharAt(storeIndex++, ' ');
                    int j = i;
                    while (j < n && sb.charAt(j) != ' ') sb.setCharAt(storeIndex++, sb.charAt(j++));
                    String t = new StringBuilder(sb.substring(storeIndex - (j - i), storeIndex)).reverse().toString();
                    sb.replace(storeIndex - (j - i), storeIndex, t);
                    i = j;
                }
                // else, skip space
            }
            sb.setLength(storeIndex);
            return sb.toString();

		}
	}

    public class Solution_sb {
        public String reverseWords(String s) {
            String res = "";
            String[] words = s.trim().split("\\s+");
            for (int i = words.length - 1; i > 0; --i) {
                res += words[i] + " ";   
            }
            return res + words[0];
        }
    }

    public class Solution {
        public String reverseWords(String s) {

            if (s == null || s.length() == 0) {
                return s;
            }

            String res = "";
            String[] words = s.trim().split("\\s+");
            for (int i = words.length - 1; i > 0; --i) {
                res += words[i] + " ";
            }
            return res + words[0];
        }
    }

}