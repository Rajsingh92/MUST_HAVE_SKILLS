import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {


	public class Solution_no_boolean_flag {

	    List<Interval> list = new ArrayList<Interval>();

	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

	        if (intervals == null || newInterval == null) {
	            return list;
        	}
	        if (intervals.size() == 0) {
	            list.add(newInterval);
	            return list;
	        }

	        for (int i = 0; i < intervals.size(); i++) {

	            Interval current = intervals.get(i);

	            if (current.end < newInterval.start) {
	                list.add(current);
	            }

	            else if (newInterval.end < current.start) {
	                list.add(newInterval);
	                newInterval = current; // @note: update newInterval as the pending to be put in list
	            }

	            else /* overlap: if (current.end >= newInterval.start) */ {
	                Interval combine =
                        new Interval(
                            Math.min(current.start, newInterval.start),
                            Math.max(current.end, newInterval.end)
                        );
	                // list.add(combine);
	                newInterval = combine;
	            }
	        }

	        // @note: last one! check lastone is merged
	        // [[1,5]], [6,8]
	        // [[1,5]], [2,3]
	        // Interval lastsecond = list.get(list.size() - 1);
	        // if (lastone.start > lastsecond.end) {
	        //     list.add(lastone);
	        // }

	        list.add(newInterval);

	        return list;
	    }
	}

}