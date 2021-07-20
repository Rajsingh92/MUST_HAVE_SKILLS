//  Josephus problem            Amazon Microsoft Walmart


public class Solution {
    // recursion
    public static int solve(int n,int k){
		if(n == 1){
			return 0;
		}
		
        int x = solve(n-1,k);
        int y = (x+k)%n;
        return y;
    }

    // linkedlist based solution
    public static void circularlist(int m) {
		tail.next = head;
		Node curr = head;
		Node prev=null;
		while (size != 1) {
			for (int i = 0; i < m - 1; i++) {
				prev=curr;
				curr = curr.next;
			}
			// remove curr
			curr.data = curr.next.data;
			curr.next = curr.next.next;
			size--;
		}
		System.out.println(prev.data);
	}
}
