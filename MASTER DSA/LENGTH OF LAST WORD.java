/**
Length of Last Word |  Easy | Adobe |

Given a string s consists of some words separated by spaces, return the length of the last word in the string. 
If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
 */
					
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0) // may be spaces availble
                    return count;
            }

        }

        return count;
    }
}


