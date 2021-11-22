/**
Polynomial Addition 

Given two polynomial numbers represented by a linked list. The task is to complete the function addPolynomial() 
that adds these lists meaning adds the coefficients who have the same variable powers.
Note:  Given polynomials are sorted in decreasing order of power.

Example 1:

Input:
LinkedList1:  (1,x2) 
LinkedList2:  (1,x3)
Output:
1x^3 + 1x^2
 */

class Solution {
    public static Node addPolynomial(Node poly1, Node poly2) {
        Node dummyHead = new Node(-1, -1);
        Node node = dummyHead;
        Node node1 = poly1, node2 = poly2;
        while (node1 != null && node2 != null) {
            if (node1.pow == node2.pow) {
                int nextCoefficient = node1.coeff + node2.coeff;
                int nextPower = node1.pow;
                if (nextCoefficient != 0) {
                    Node nextNode = new Node(nextCoefficient, nextPower);
                    node.next = nextNode;
                    node = node.next;
                }
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.pow > node2.pow) {
                Node nextNode = new Node(node1.coeff, node1.pow);
                node.next = nextNode;
                node = node.next;
                node1 = node1.next;
            } else {
                Node nextNode = new Node(node2.coeff, node2.pow);
                node.next = nextNode;
                node = node.next;
                node2 = node2.next;
            }
        }
        if (node1 != null)
            node.next = node1;
        else if (node2 != null)
            node.next = node2;

        return dummyHead.next;
    }
}