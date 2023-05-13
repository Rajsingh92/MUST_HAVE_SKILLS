/**
Minimum Number of Refueling Stops |  Hard | Amazon |

A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 

Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
 */


import java.util.*;
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int refuellingStops = 0;
        int fuelInTank = startFuel;
        int prevPos = 0;

        for (int i = 0; i < stations.length; i++) {
            int currPos = stations[i][0];
            int fuel = stations[i][1];
            fuelInTank = fuelInTank - (currPos - prevPos);

            while (pq.size() > 0 && fuelInTank < 0) {
                fuelInTank += pq.poll();
                refuellingStops++;
            }

            if (fuelInTank < 0) {
                return -1;
            }

            pq.offer(fuel);
            prevPos = currPos;
        }

        fuelInTank = fuelInTank - (target - prevPos);

        while (pq.size() > 0 && fuelInTank < 0) {
            fuelInTank += pq.poll();
            refuellingStops++;
        }

        if (fuelInTank < 0) {
            return -1;
        }

        return refuellingStops;
    }
}
