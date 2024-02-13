import java.util.*;

class Main {
    public static class MovingAverage {

        Queue<Integer> q;
        int size;
        double sum;

        public MovingAverage(int size) {
            q = new LinkedList<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            q.add(val);
            sum += val;

            if (q.size() > size) {
                sum = sum - q.poll();
            }
            return (double) sum / q.size();
        }
    }
}
