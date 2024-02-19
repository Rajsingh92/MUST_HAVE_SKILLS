
public class Main {
    public class compareNode implements Comparator<Node>{
        public int compare(Node n1,Node n2){
            return n1.data-n2.data;
        }
    }

    public static Node sortAKSortedDLL(Node head,int k){
        if(head == null){
            return head;
        }

        PriorityQueue < Node > pq = new PriorityQueue < Node > (new compareNode());
        Node nh = null;  
        Node last = null;

        // first k elements
        for (int i = 0; head != null && i <= k; i++) {
            pq.add(head);
            head = head.next;
        }

        while(pq.size()>0){
            Node val = pq.remove();

            // add in list
            if(nh == null){
                nh = val;
                nh.prev = null;
                last = val;
            }else{
                last.next = val;
                val.prev = last;
                last = val;
            }

            // add next to pq
            if(head!=null){
                pq.add(head);
                head = head.next;
            }
        }

        last.next = null;
        return nh;
    }
}