/**
Word Ladder  | Affirm, Airbnb, Amazon, Apple, Facebook, Google, Microsoft |


A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 */


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        HashMap<String, Boolean> map = new HashMap<>();

        for (String str : wordList) {
            map.put(str, false);
        }

        map.put(beginWord, true);

        int ans = 1;

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                String rem = queue.removeFirst();
                if (rem.equals(endWord)) {
                    return ans;
                }

                for (int i = 0; i < rem.length(); i++) {
                    char[] charr = rem.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charr[i] = ch;
                        String str = new String(charr);

                        if (map.containsKey(str)) {
                            if (map.get(str) == false) {
                                queue.addLast(str);
                                map.put(str, true);
                            }
                        }

                    }
                }
            }
            ans++;
        }

        return 0;
    }
}

// Word Ladder II |  Hard | Facebook, Google, Microsoft |