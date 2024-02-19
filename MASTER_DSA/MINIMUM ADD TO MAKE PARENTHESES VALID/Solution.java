
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        
        for(int i= 0 ; i<S.length();i++){
            char ch = S.charAt(i);
            if(st.size()!=0 && st.peek() == '(' && ch == ')'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        
        return st.size();
    }

    public int minAddToMakeValid2(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}