import java.util.*;

class solution {

    public int minMeetingRooms(int[][] intervals) {

        //Sort the items in the array
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //Define the minHeap data structure
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       
        //Add the first item end time to start
        minHeap.add(intervals[0][1]);

        //Iterate through the array to find an overlapping range
        for (int i = 1; i < intervals.length; i++) {
          int[] cur = intervals[i];
          if (cur[0] >= minHeap.peek()) {
            minHeap.poll();
          }
          minHeap.add(cur[1]);
        }

        return minHeap.size();
    }

}

/*
 Time complexity:
 .sort Method of Arrays class has time complexity of NLogN where N is the 
 number of Intervals.
 There is an Iteration through N Items in the code snippet
 Therefore the time complexity would be O(NlogN)

 Space complexity:
 .Sort method of Arrays class uses N space for internal operations

 in worst case where N number of meetings overlap the minHeap will have
 N elements therefore the time complexity would be O(N)


Problem:
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Solution:
1- we need to sort the meeting intervals based on their start time
This is to make sure that the start time of the preceding element is not
going to be larger.

The end time of each meeting should not overlap with the start time of
preceding meetings, the end time of the meeting that ends earlier should be
considered for compare first, as we need to make sure an earlier time is not
overlapping with the start time of meetings.
That is why we can use a minHeap Data structure, as soon as we make sure this
end time is not overlapping, we just remove it, which will be replaced by the
next smaller end time in the heap.

At the end only the elements overlapping and the cur element need a room
which is equal to the size of minHeap.


Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2


Example 2:
Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.



 */