/**
First Unique Character in a String |  Easy | Amazon, Apple, Facebook, Google, Microsoft |
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, 
return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 */


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (fmap.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }

    static void firstNonRepeating(String str) {
        int[] charCount = new int[26];

        Queue<Character> q = new LinkedList<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            q.add(c);
            charCount[c - 'a']++;

            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }

            if (q.isEmpty())
                System.out.print(-1 + " ");
        }

        System.out.println();
    }
}