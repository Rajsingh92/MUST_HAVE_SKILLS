/**
Insert Delete GetRandom O(1) |  Medium | Microsoft |

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
 */

import java.util.*;

class RandomizedSet {

	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;

	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}

		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		int index = map.get(val);
		Collections.swap(list, index, list.size() - 1);
		map.put(list.get(index), index);
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		Random random = new Random();
		int n = random.nextInt(list.size());
		return list.get(n);
	}
}
