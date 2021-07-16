import java.util.HashMap;
import java.util.Map;

public class Max_Points_on_a_Line {

	public static void main(String[] args) {

		double a = 0.0 / (-1);
		System.out.println("a:" + a);

		double b = 0.0 / (1);
		System.out.println("b:" + b);

		System.out.println("a == b ? " + (a == b)); // output: true

		HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
		hm.put(a, 1);
		hm.put(b, 1);
		// @note:@memorize: so, different keys
		System.out.println("hashmap keys: " + (hm.keySet())); // output: [-0.0, 0.0]

	}

	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	public class Solution {
		public int maxPoints(Point[] points) {
			if (points == null || points.length == 0)
				return 0;

			// line slope => number of points
			HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
			int max = 0;

			// have to touch every possible line, so O(logN)
			for (int i = 0; i < points.length; i++) {
				int duplicate = 1;
				int vertical = 0;
				for (int j = i + 1; j < points.length; j++) {
					// @note:@memorize: handle duplicates and vertical
					if (points[i].x == points[j].x) {
						if (points[i].y == points[j].y) {
							duplicate++; // itself
						} else {
							vertical++; // vertical line at the same x position
						}
					} else {
						double slope = points[j].y == points[i].y ? 0.0 : (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);

                        hm.merge(slope, 1, (a, b) -> a + b);
					}
				}

				// record max number of points for one line
				for (Integer count : hm.values()) {
					if (count + duplicate > max) {
						max = count + duplicate;
					}
				}

				// @note:@memorize: special case for vertical line points
				max = Math.max(vertical + duplicate, max);

				hm.clear(); // @note: api, better than create a new hashmap?
			}

			return max;
		}

	}
}