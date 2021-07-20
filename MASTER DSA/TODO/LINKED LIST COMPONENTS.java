/**
Linked List Components |  Medium | Google |

We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> subset = new HashSet<Integer>();
        for (int value : G)
            subset.add(value);
        boolean inComponent = false;
        int components = 0;
        ListNode node = head;
        while (node != null) {
            int value = node.val;
            if (subset.contains(value)) {
                if (!inComponent) {
                    inComponent = true;
                    components++;
                }
            } else {
                if (inComponent)
                    inComponent = false;
            }
            node = node.next;
        }
        return components;
    }
}