import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class TimeValue {
  int timeStamp;
  String val;

    public TimeValue(int time,String val) {
      timeStamp = time;
      this.val = val;
    }

}

public class TimeMapBST {

  HashMap<String, List> map;

  public TimeMapBST() {
        map = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
      map.computeIfAbsent(key, k-> new ArrayList<>()).add(new TimeValue(timestamp, value));
      List<TimeValue> list = map.get(key);
      Collections.sort(list , Comparator.comparingInt(tv -> tv.timeStamp));
  }
  
  public String get(String key, int timestamp) {

      //get the array of time-value pairs for the key
      List<TimeValue> list = map.getOrDefault(key, null);
      
      if (list==null) return "";
      int start = 0, end = list.size()-1;
      if (list.get(start).timeStamp > timestamp) return "";
      if(list.get(end).timeStamp <= timestamp ) return list.get(end).val;

      //Implementing bts 
      while(start<=end) {
        int mid = (start + end)/2;
        
        if (list.get(mid).timeStamp == timestamp) return list.get(mid).val;
        if (list.get(mid).timeStamp < timestamp) start = mid+1; 
        else end = mid-1;

      }
      return "";
  }
}
