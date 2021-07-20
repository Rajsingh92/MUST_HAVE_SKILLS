/**
Flatten a Multilevel Doubly Linked List |  Medium | Amazon |
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child 
pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more 
children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the 
first level of the list.

 

Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 */

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        
        Node dummy = new Node(0,null,head,null);
        Node prev = dummy;
        Stack<Node> st = new Stack<>();
        st.push(head);
        
        while(st.size()!=0){
            Node root = st.pop();
            
            root.prev = prev;
            prev.next = root;
            
            if(root.next!=null){
                st.push(root.next);
                root.next = null;
            }
            
            if(root.child!=null){
                st.push(root.child);
                root.child = null;
            }
            
            prev = root;
        }
        
        dummy.next.prev = null;
        return dummy.next;
    }
}

/**
{10, 5, 12, 7, 11}
{4, 20, 13}
{17, 6}
{9, 8}
{19, 15}
{2}
{16}
{3}


10 5 12 7 11 4 20 13 17 6 2 16 9 8 3 19 15
 */

public class Solution{  //level wise
    public static void flatten(Node Node){
        if(node == null){
            return;
        }
        Node curr = node;
        Node tail = node;
        while(tail.next!=null){
            tail = tail.next;
        }

        while(curr!=null){
            if(curr.child!=null){
                tail.next = curr.child;
                curr.child = null;

                while(tail.next!=null){
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }

    }
}

public class Solution{ //depth wise
    public static void flatten(Node node){
        if(root == null){
            return;
        }

        Node right = node.next;
        node.next = flatten(node.down);
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = flatten(right);
        return node;
    }
}

//sorted flattening
public class Solution
    {
        Node flatten(Node root)
        {
            if(root==null || root.next==null){
                return root;
            }
            Node right = flatten(root.next);
            root = merge(root,right);
            return root;
        }
        
        Node merge(Node a ,Node b){
            if(a==null){
                return b;
            }
            if(b==null){
                return a;
            }
            
            Node result;
            if(a.data>b.data){
                result = b;
                result.bottom = merge(a,b.bottom);
            }else{
                result = a;
                result.bottom = merge(a.bottom,b);
            }
            
            result.next = null;
            return result;
        }
    }



