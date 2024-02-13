/**
Bulls and Cows |  Medium | Amazon, Google |

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

 

Example 1:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be 
rearranged to allow one 1 to be a bull.
 */

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> sec = new HashMap<Character, Integer>();
        HashMap<Character, Integer> gue = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                char a = secret.charAt(i);
                char b = guess.charAt(i);
                if (!sec.containsKey(a)) {
                    sec.put(a, 1);
                } else {
                    sec.put(a, sec.get(a) + 1);
                }
                if (!gue.containsKey(b)) {
                    gue.put(b, 1);
                } else {
                    gue.put(b, gue.get(b) + 1);
                }
            }
        }
        for (Character c : gue.keySet()) {
            if (sec.containsKey(c)) {
                cows += Math.min(sec.get(c), gue.get(c));
            }
        }
        return bulls + "A" + cows + "B";
    }
}