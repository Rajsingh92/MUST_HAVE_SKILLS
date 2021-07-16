/**
Letter Tile Possibilities

You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 */

class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tiles.length(); i++) {
            char ch = tiles.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        counter = 0;
        helper(map, "", tiles.length());

        return counter - 1;
    }

    static int counter;

    public void helper(HashMap<Character, Integer> map, String asf, int count) {

        if (asf.length() > 0) {
            System.out.println(asf);
        }

        counter++;

        if (count == 0) {
            return;
        }

        for (char key : map.keySet()) {
            if (map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                helper(map, asf + key, count - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}