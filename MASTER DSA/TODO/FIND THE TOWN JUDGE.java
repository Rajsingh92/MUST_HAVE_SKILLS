/**
Find the Town Judge

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly 
the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the 
person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1)
                return i;
        }
        return -1;
    }

    public int findJudge2(int N, int[][] trust) {
        if (trust.length == 0 && N == 1)
            return 1;
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            hs.add(trust[i][0]);

            int key = trust[i][1];
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }

        for (Integer key : hm.keySet()) {
            if (hm.get(key) == N - 1 && hs.contains(key) == false)
                return key;
        }

        return -1;
    }
}