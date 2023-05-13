/**
Goal Parser Interpretation

You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", 
"()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the 
string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the 
original order.

Given the string command, return the Goal Parser's interpretation of command.

 

Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
 */

class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < command.length()) {
            char ch = command.charAt(i);

            if (ch == 'G') {
                sb.append('G');
                i += 1;
            } else if (ch == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i += 2;
                } else {
                    sb.append("al");
                    i += 4;
                }
            }
        }

        return sb.toString();
    }
}