/**
Time Based Key-Value Store |  Medium | Facebook |

Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.
2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").
 */


class TimeMap {

    HashMap<String, HashMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> temp = map.getOrDefault(key, new HashMap<Integer, String>());
        temp.put(timestamp, value);
        map.put(key, temp);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            Map<Integer, String> tempMap = map.get(key);
            for (int i = timestamp; i >= 0; i--) {
                if (tempMap.containsKey(i)) {
                    return tempMap.get(i);
                }
            }
            return "";
        }else {
            return "";
        }
    }
}