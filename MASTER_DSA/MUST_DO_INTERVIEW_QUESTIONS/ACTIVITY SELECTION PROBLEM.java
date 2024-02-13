// activity selection problem
public class Solution {

    private static class Pair implements Comparable<Pair> {
        int start;
        int finish;

        public Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int compareTo(Pair o) {
            return this.finish - o.finish;
        }
    }

    public static void solve(int[] start, int[] end) {

        Pair[] pairs = new Pair[start.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(pairs);

        System.out.println(pairs[0].start + " " + pairs[0].finish);
        int i = 0;
        for (int j = 1; j < pairs.length; j++) {
            if (pairs[j].start >= pairs[i].finish) {
                System.out.println(pairs[j].start + " " + pairs[j].finish);
                i = j;
            }
        }

    }

}
