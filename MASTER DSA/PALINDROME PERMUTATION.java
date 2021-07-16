/**
Palindrome Permutation |  Easy | Amazon, Facebook, Google, Microsoft |

Description
Given a string, determine if a permutation of the string could form a palindrome.


Example 1

Input: s = "code"
Output: False

Example 2

Input: s = "aab"
Output: True
Explanation: 
"aab" --> "aba"
 */

public class Solution {

    public boolean canPermutePalindrome(String s) {
        int countodds = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (freq % 2 != 0) {
                countodds++;
            }
        }

        return countodds > 1 ? false : true;
    }
}