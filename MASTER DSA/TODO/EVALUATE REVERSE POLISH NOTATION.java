/**
Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
 */

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> st = new Stack<>();
  
      for (int i = 0; i < tokens.length; i++) {
        String ss = tokens[i];
  
        if (ss.equals("+") || ss.equals("-") || ss.equals("*") || ss.equals("/")) {
          int a = st.pop();
          int b = st.pop();
  
          if (ss.equals("+"))
            st.push(b + a);
          if (ss.equals("-"))
            st.push(b - a);
          if (ss.equals("*"))
            st.push(b * a);
          if (ss.equals("/"))
            st.push(b / a);
  
        } else {
          st.push(Integer.parseInt(ss));
        }
      }
  
      return st.pop();
    }
  }