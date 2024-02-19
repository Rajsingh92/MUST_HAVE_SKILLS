import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofDisks = scn.nextInt();
        tohiterative('A', 'B', 'C', noofDisks);
    }

    public static void toh(int n, int t1id, int t2id, int t3id) {
        if (n == 0) {
            return;
        }

        toh(n - 1, t1id, t3id, t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        toh(n - 1, t3id, t2id, t1id);
    }

    private static class tohHelper {
        char s;
        char d;
        char h;
        boolean selfdone;
        boolean leftdone;
        boolean rightdone;
        int noofdisks;

        public tohHelper(char s, char d, char h, boolean selfdone, boolean leftdone, boolean rightdone, int noofdisks) {
            this.s = s;
            this.d = d;
            this.h = h;
            this.selfdone = selfdone;
            this.leftdone = leftdone;
            this.rightdone = rightdone;
            this.noofdisks = noofdisks;
        }
    }

    private static void tohiterative(char s, char d, char h, int noofDisks) {
        LinkedList<tohHelper> stack = new LinkedList<>();
        tohHelper root = new tohHelper(s, d, h, false, false, false, noofDisks);
        stack.addFirst(root);

        while (stack.isEmpty() == false) {
            tohHelper pop = stack.getFirst();
            if (pop.leftdone == false && pop.noofdisks != 0) {
                // swap d and h and add to the stack
                pop.leftdone = true;
                tohHelper newtoh = new tohHelper(pop.s, pop.h, pop.d, false, false, false, pop.noofdisks - 1);
                stack.addFirst(newtoh);

            } else if (pop.selfdone == false) {
                if (pop.noofdisks != 0) {
                    System.out.println("Move " + pop.noofdisks + " from " + pop.s + " to " + pop.d);
                } else {
                    stack.removeFirst();
                }
                pop.selfdone = true;
            } else if (pop.rightdone == false && pop.noofdisks != 0) {
                // swap s and h and add to the stack
                // remove pop
                pop.rightdone = true;
                tohHelper newtoh = new tohHelper(pop.h, pop.d, pop.s, false, false, false, pop.noofdisks - 1);
                stack.addFirst(newtoh);
            } else {
                stack.removeFirst();
            }
        }
    }
}
