/**
Top K Frequent Words |  Medium | Amazon, Apple, Facebook, Google, Microsoft |

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
 */

import java.util.*;
class Solution {

    private class Node implements Comparable<Node> {
        public String str;
        public int freq;

        public Node(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node o) {
            if (this.freq == o.freq) {
                return o.str.compareTo(this.str);
            }
            return this.freq - o.freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String str : map.keySet()) {
            pq.add(new Node(str, map.get(str)));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<String> res = new ArrayList<>();
        while (pq.size() > 0) {
            Node rem = pq.poll();
            res.add(rem.str);
        }

        Collections.reverse(res);

        return res;
    }
}