/**
Camelcase Matching

A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals 
the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only 
if queries[i] matches the pattern.

 
Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: 
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 */

class Solution {

    public boolean isPatternValid(String query, String pattern) {

        int q = 0;
        int p = 0;

        while (q < query.length() && p < pattern.length()) {
            char ch1 = query.charAt(q);
            char ch2 = pattern.charAt(p);

            if (ch1 == ch2) {
                q++;
                p++;
            } else {
                if (ch1 >= 'a' && ch1 <= 'z') {
                    q++;
                } else {
                    return false;
                }
            }
        }

        while (p == pattern.length() && q < query.length()) {
            char ch = query.charAt(q);
            if (ch >= 'a' && ch <= 'z') {
                q++;
            } else {
                return false;
            }
        }

        if (q == query.length() && p != pattern.length()) {
            return false;
        }

        return true;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(isPatternValid(queries[i], pattern));
        }
        return ans;
    }
}