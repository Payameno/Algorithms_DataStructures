import java.util.*;

class solution {

    public boolean canAttendMeetings(int[][] intervals) {

        boolean res = true;

        //Base case
        int n = intervals.length;
        if (n == 0) return res;

        //Sort the items in the array
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //Define the pre pointer 
        int[] pre = intervals[0];

        //Iterate through the array to find an overlapping range
        for (int i = 1; i < intervals.length; i++) {
            /*
             [[0,30],[5,10],[15,20]]
               Pre
            
             [[2,4], [7,10]]
                      Pre

               Case1 (pre[1] <= intevals[i]) pre = intevals[i]
               [0,5], [5,10]

               Case2  (pre[1] > intevals[i]) res = false
                [0,5], [0,10]
             */

             if (pre[1] > intervals[i][0]) {
                res = false;
             } else if (pre[1] <= intervals[i][0]) {
                pre = intervals[i];
             }


        }
        return res;
    }

}

/*
 Time complexity:
 O(NlogN) 
 Nlogn time complexity for sorting + N for iteration through the intervals array

 Space complexity:
O(1) constant time complexity

Problem:
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
 */