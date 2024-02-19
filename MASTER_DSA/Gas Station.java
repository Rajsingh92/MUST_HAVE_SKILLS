public class Gas_Station {

    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            // skip valid check
            if (gas.length == 0) {
                return 0;
            }

            int[] diff = new int[gas.length];
            for (int i = 0; i < diff.length; i++) {
                diff[i] = gas[i] - cost[i]; // meaning gas left when arriving next station
            }

            int sum = 0;
            int total = 0;
            int index = 0;
            for (int i = 0; i < diff.length; i++) {

                sum += diff[i];
                total += diff[i];

                if (sum < 0) {
                    sum = 0;
                    index = i + 1; // sum from last loop, i-1, current is pointing to i
                }

            }

            return total >= 0 ? index : -1;
        }
    }
}