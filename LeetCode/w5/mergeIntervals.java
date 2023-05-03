/*
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
   Output: [[1,6],[8,10],[15,18]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {
  public int[][] merge(int[][] intervals) {
    if(intervals==null || intervals.length==0) {
      return new int[0][];
    }

    //sort intervals
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merged = new ArrayList<>();
    int[] mergedInterval = intervals[0];

    for (int i=1; i<intervals.length; i++) {
      
      int[] interval = intervals[i];

      if(mergedInterval[1]>=interval[0]) {
        mergedInterval[1] = Math.max(interval[1], mergedInterval[1]);
      } else {
        merged.add(mergedInterval);
        mergedInterval = intervals[i];
      }
    }

    merged.add(mergedInterval);

    return merged.toArray( new int[merged.size()][]);
  }
}