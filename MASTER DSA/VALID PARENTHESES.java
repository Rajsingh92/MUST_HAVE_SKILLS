/**
Valid Parentheses |  Easy | Adobe, Akuna Capital, Amazon, Apple, Facebook, Google, Microsoft |
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:
Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
 */



class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.size()==0){
                    return false;
                }
                
                char topBracket = st.pop();
                if(topBracket == '('){
                    if(ch!=')'){
                        return false;
                    }
                }else if(topBracket == '{'){
                    if(ch!='}'){
                        return false;
                    }
                }else if(topBracket == '['){
                    if(ch!=']'){
                        return false;
                    }
                }
            }
        }
        
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
