// https://leetcode.com/problems/time-based-key-value-store/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class TimeBasedKeyValueStore {
    private Map<String, List<Pair>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> pairs = map.get(key);
        int left = 0, right = pairs.size() - 1;
        String result = "";

        // Binary search to find the value with largest timestamp <= input timestamp
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (pairs.get(mid).timestamp <= timestamp) {
                result = pairs.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair {
        String value;
        int timestamp;

        Pair(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();

        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // "bar"
        System.out.println(timeMap.get("foo", 3)); // "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // "bar2"
        System.out.println(timeMap.get("foo", 5)); // "bar2"
    }
}
