/**
Construct Binary Tree from Parent Array 

Given an array of size N that can be used to represents a tree. The array indexes are values in tree nodes and array 
values give the parent node of that particular index (or node). The value of the root node index would always be -1 
as there is no parent for root. Construct the standard linked representation of Binary Tree from this array representation.

 

Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like 
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6
 */

public class Solution {
    
    public static Node createTree(int parent[], int N) {
        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i, new Node(i));
        }

        Node root = null;
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                root = map.get(i);
            } else {
                Node ptr = map.get(parent[i]);

                if (ptr.left == null) {
                    ptr.left = map.get(i);
                } else {
                    ptr.right = map.get(i);
                }
            }
        }

        return root;
    }

}