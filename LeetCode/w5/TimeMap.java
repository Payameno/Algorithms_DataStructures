/*
 * TreeMap is used to implement red-black tree (balanced bts)
 */

import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
  HashMap<String,TreeMap<Integer,String>> map;

  public TimeMap() {
      map = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
      
    if (!map.containsKey(key)) {
      //set the key with new value and timestamp
      TreeMap<Integer, String> treemap = new TreeMap<>();
      treemap.put(timestamp, value);
      map.put(key, treemap);
      
    } else {
      //add the new value to the existing key
      map.get(key).put(timestamp, value);
    }

  }
  
  public String get(String key, int timestamp) {
    
    if (map.containsKey(key)) {
      if (map.get(key).containsKey(timestamp)) {
        return map.get(key).get(timestamp);
      } else {
        Integer previousTimeStamp = map.get(key).floorKey(timestamp);
        
        //the case where mapped a key to a null value in Hashmap
        if (previousTimeStamp != null) {
          return map.get(key).get(previousTimeStamp);
        }
      }
    }

    return "";
  }

}

/**
* Your TimeMap object will be instantiated and called as such:
* TimeMap obj = new TimeMap();
* obj.set(key,value,timestamp);
* String param_2 = obj.get(key,timestamp);
*/