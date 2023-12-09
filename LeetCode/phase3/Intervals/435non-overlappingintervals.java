import java.util.*;

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        //Sort in the input
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //Count the number of intervals to remove
        int remove = 0;
        
        //Set a pointer
        int[] pre = intervals[0];

        //Loop through the array and evaluate intervals
        for (int i = 1; i < intervals.length; i++) {
            /*
            intervals = [[1,2],[1,3],[2,3],[3,4]]
                          Pre
            */
            if (pre[1] > intervals[i][0]) {
                //Decide whether to move pre pointer (smallest amount of the last range)
                if (pre[1] > intervals[i][1]) {
                    pre = intervals[i];
                }
                remove++;
            } else if (pre[1] <= intervals[i][0]) {
                pre = intervals[i];
            }
        }
        return remove;
    }
}

/*
 Time complexity:
 O(NlogN) where N is the number of elements in the intervals
 1- .sort method of Arrays class will take O(NlogN) time complexity to sort the intervals
 2-Iteration through the array to find overlapping ranges takes N iterations

 Space complexity:
 O(1) constant
 
 Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
 */