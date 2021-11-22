/**
Word Search | Amazon, Apple, Facebook, Microsoft |

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0 || board[0].length == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(dfs(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, boolean[][] visited, int x, int y, String word, int k){
        if(word.length() == k) 
            return true;

        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]|| word.charAt(k) != board[x][y] ) 
            return false;

        visited[x][y] = true;

        boolean res = dfs(board, visited, x+1, y, word, k+1)
                        || dfs(board, visited, x-1, y, word, k+1)
                        || dfs(board, visited, x, y+1, word, k+1)
                        || dfs(board, visited, x, y-1, word, k+1);

        visited[x][y] = false;
        return res;
    }
}


/**
public class Solution {
    public class TrieNode{
        public boolean isWord = false;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){
            
        }
    }
    
    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];
        
        addToTrie(words);
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, "", result);
                }
            }
        }
        
        return new LinkedList<>(result);
    }
    
    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }
    
    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]|| node.child[board[i][j] - 'a'] == null){
            return;
        }
        
        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.isWord){
            result.add(word + board[i][j]);
        }
        
        search(board, i-1, j, node, word + board[i][j], result);
        search(board, i+1, j, node, word + board[i][j], result);
        search(board, i, j-1, node, word + board[i][j], result);
        search(board, i, j+1, node, word + board[i][j], result);
        
        flag[i][j] = false;
    }
}
 */