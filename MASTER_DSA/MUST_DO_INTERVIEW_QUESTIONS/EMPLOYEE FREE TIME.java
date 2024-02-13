/**
Employee Free Time |  Hard | Airbnb, Amazon, Google, Microsoft |

We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

The Intervals is an 1d-array. Each two numbers shows an interval. For example, [1,2,8,10] represents that the employee works in [1,2] and [8,10].

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

1.schedule and schedule[i] are lists with lengths in range [1, 100].
2.0 <= schedule[i].start < schedule[i].end <= 10^8.

Example
Example 1:

Input：schedule = [[1,2,5,6],[1,3],[4,10]]
Output：[(3,4)]
 */




import java.util.*;
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> que = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (List<Interval> list : schedule) {
            for (Interval i : list) {
                que.add(i);
            }
        }

        List<Interval> rt = new ArrayList<>();
        int max = -1;
        while (!que.isEmpty()) {
            Interval top = que.poll();
            if (max != -1 && top.start > max) {
                rt.add(new Interval(max, top.start));
            }
            max = Math.max(max, top.end);
        }

        return rt;
    }
}
