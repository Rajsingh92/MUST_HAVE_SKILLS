/**
Anagram Palindrome 
Given a string S, Check if characters of the given string can be rearranged to form a palindrome. 
For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, 
but characters of “geeksforgeeks” cannot be rearranged to form a palindrome.
 */





class GFG {
    static final int NO_OF_CHARS = 26;
    public static boolean anagramPalindrome(String str){
        int n = str.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++) freq[str.charAt(i) - 'a']++;

        int oddCount = 0;
        for(int i=0;i<26;i++){
            if((freq[i] % 2) != 0 && ++oddCount > 1) return false;   
        }

        return true;
    }
}