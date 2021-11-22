/**
Excel Sheet Column Number |  Easy | Akuna Capital |

Given a string columnTitle that represents the column title as appear in an Excel sheet, return its 
corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
 */

class Solution {
    public int titleToNumber(String s) {

        int base = 1;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int num = ch - 'A' + 1;
            res += num * base;
            base = base * 26;
        }

        return res;
    }
}



/**
Excel Sheet Column Title |  Easy | Akuna Capital |

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
 */

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            int rem = columnNumber % 26;

            if (rem == 0) {
                sb.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            } else {
                sb.append((char) ('A' + (rem - 1)));
                columnNumber = columnNumber / 26;
            }
        }

        sb = sb.reverse();
        return sb.toString();
    }
}

