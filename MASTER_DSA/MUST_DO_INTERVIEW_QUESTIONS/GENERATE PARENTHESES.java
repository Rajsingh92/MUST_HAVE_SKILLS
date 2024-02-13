/**
Generate Parentheses |  Medium | Adobe, Aetion |

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
 */


import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        solve("", n, n, res);
        return res;
    }

    public void solve(String psf, int o, int c, List<String> res) {
        if (o == 0 && c == 0) {
            res.add(psf);
            return;
        }

        if (o > 0) {
            solve(psf + "(", o - 1, c, res);
        }

        if (c > o) {
            solve(psf + ")", o, c - 1, res);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    private void generate(String s, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if (left < 0 || right < 0 || left > right)
            return;

        generate(s + '(', left - 1, right, res);
        generate(s + ')', left, right - 1, res);

    }
}