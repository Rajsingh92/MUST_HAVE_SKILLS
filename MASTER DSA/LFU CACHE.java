/**
LFU Cache |  Hard | Amazon |

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 */



import java.util.*;

public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int min = -1;

    public LFUCache(int cap) {
        capacity = cap;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;

        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);

        if (count == min && lists.get(count).size() == 0) {
            min++;
        }

        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }

        lists.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() >= capacity) {
            int minFreKey = lists.get(min).iterator().next();
            lists.get(min).remove(minFreKey);
            vals.remove(minFreKey);
            counts.remove(minFreKey);
        }

        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        if (!lists.containsKey(1)) {
            lists.put(1, new LinkedHashSet<>());
        }
        lists.get(1).add(key);
    }
}
