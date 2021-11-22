/**
Jewels and Stones |  Easy | Adobe, Alibaba, Amazon, Apple, Google |

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones 
you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have 
are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}