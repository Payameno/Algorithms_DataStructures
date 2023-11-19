package BinarySearch;
import java.util.*;

class TimeMap {

    class timeValue {
        int time;
        String value;

        public timeValue(String nodeValue, int nodeTime) {
            this.time = nodeTime;
            this.value = nodeValue;
        }
    }

    public TimeMap() {
        
    }

    //Map Each key to timeValue
    HashMap<String, List<timeValue>> hm = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)) {
            hm.put(key, new ArrayList<>());
        }

        //Add the value timeStamp pair to the list of the key
        List<timeValue> list = hm.get(key);
        list.add(new timeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) return "";
        List<timeValue> list = hm.get(key);

        //define binary search pointers
        int left = 0, right = list.size() - 1;

        while (left + 1 < right) {
            int md = left + right / 2;
            timeValue midTimeValue = list.get(md);

            if (midTimeValue.time == timestamp) {
                return midTimeValue.value;
            } else if (midTimeValue.time < timestamp) {
                left = md;
            } else {
                right = md;
            }
        }

        //After the while loop, if not found, it should be either left, right or not found
        if (list.get(right).time <= timestamp) {
            return list.get(right).value;
        } else if (list.get(left).time <= timestamp) {
            return list.get(left).value;
        } else {
            return "";
        }
    }

}

/**
 * 

   Set method:

    Time complexity: O(1)
    Space complexity: O(NxM), HashMap is going to store N keys, M the average of items in
    each key's list.

   Get Method:

    Time complexity: O(logM) where M is the number of items in a key's list
    Space complexity: O(1)


Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
 

Constraints:

1 <= key.length, value.length <= 100
key and value consist of lowercase English letters and digits.
1 <= timestamp <= 107
All the timestamps timestamp of set are strictly increasing.
At most 2 * 105 calls will be made to set and get.

 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 * 
 * 
 */