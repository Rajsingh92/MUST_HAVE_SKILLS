// Meeting Rooms 


/**
Meeting Rooms II |  Medium | Amazon, Facebook, Google, Microsoft |

Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example
Example1

Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)
 */




import java.util.*;
public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            if (pq.peek() > intervals.get(i).start) {
                // do nothing
            } else {
                pq.poll();
            }

            pq.add(intervals.get(i).end);
        }

        return pq.size();
    }
}
