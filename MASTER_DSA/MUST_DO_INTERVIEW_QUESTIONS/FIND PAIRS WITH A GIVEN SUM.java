/**
Find pair for given sum in a sorted singly linked without extra space
Given a sorted singly linked list and a value x, the task is to find pair whose sum is equal to x. We are not 
allowed to use any extra space and expected time complexity is O(n).

Examples:

Input : head = 3-->6-->7-->8-->9-->10-->11 , x=17
Output: (6, 11), (7, 10), (8, 9)
 */

public class Solution{

    private static Node getmidnode(Node head) {
		Node fast=head;
		Node slow=head;
		while(fast!=null) {
			fast=fast.next;
			if(fast!=null) {
				fast=fast.next;
				slow=slow.next;
			}
		}
		
		Node head2=slow.next;
		slow.next=null;
		return head2;
    }
    
    private static Node reverselist(Node head2) {
		Node prev=null;
		Node curr=head2;
		Node next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			
			prev=curr;
			curr=next;
			
		}
		
		head2=prev;
		return head2;
    }

    private static void pairtargetsum(Node head,Node head2, int target) {
		Node temp=head;
		while(head2!=null && temp!=null) {
			if(head2.data+temp.data<target) {
				temp=temp.next;
			}else if(head2.data+temp.data>target) {
				head2=head2.next;
			}else {
				System.out.println(temp.data+" "+head2.data);
				temp=temp.next;
				head2=head2.next;
			}
		}
	}
    
    public static void main(String[] args) {
		Node head2=getmidnode(head);
		head2=reverselist(head2);
		pairtargetsum(head2,target);

	}

}


/**
 * 
Find pairs with given sum in doubly linked list
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in doubly linked list 
whose sum is equal to given value x, without using any extra space ? 

Example:  

Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
        x = 7
Output: (6, 1), (5,2)
 */

public class Solution{
    public static void pairSum(Node head,int x){
        Node start = head;
        Node end = head;
        boolean flag = false;

        while(end.next!=null){
            end= end.next;
        }

        while(start!=null && end!=null && start!=end && end.next!=start){
            if(start.data+end.data == x){
                    flag = true;
                    System.out.println(start,end);
                    start = start.next;
                    end = end.prev;

            }else{
                if(start.data+end.data<x){
                    start = start.next;
                }else{
                    end = end.prev;
                }
            }
        }

        if(!flag){
            System.out.println("No Found");
        }
    }
}



