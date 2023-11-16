import java.util.*;

class Solution {
    public int[][] insert1(int[][] intervals, int[] newInterval) {

        //Create our list
        List<int[]> list = new LinkedList<>();

        int i = 0, n = intervals.length;

        //if the interval is non-overlapping, add it to the lis
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }           

        //if the interval is overlapping, merge
        while (i < n && newInterval[0] <= intervals[i][1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[0] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        //add the remainder intervals
        while(i < n) {
            list.add(intervals[i]);
        }

        //return the list
        return list.toArray(new int[list.size()][2]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {

        // sc1: newInterval: [3,4]  Intervals [5,6] [7,8] [9.10]
        //stack [3,4] [5,6] [7,8] [9,10]

        // sc2: newInterval: [3,6]  Intervals [5,8] [9,10] [11,12]
        // stack [3,8],[9,10],[11,12]

        // sc3: newInterval: [6,11]  Intervals [5,8] [9,10] [11,12]
        //i = 2
        // stack [5,11] 

        // sc4: newInterval: [13,16]  Intervals [5,8] [9,10] [11.12]

        Stack<int[]> stack = new Stack<>();

        int i = 0, n = intervals.length;

        while (i <= n) {

            if (i == n || newInterval[0] < intervals[i][0]) {

                if (stack.isEmpty()) {
                    stack.add(newInterval);
                } else if (newInterval[0] <= stack.peek()[1]) {
                    //Prev element in stack is in conflict with newInterval
                    stack.peek()[1] = Math.max(newInterval[1], stack.peek()[1]);
                } else {
                    //Prev interval is not in conflict with the new interval
                    stack.add(newInterval);
                }
                break;
            } 
            stack.add(intervals[i]);
            i++;
        }

        //Add the remainder intervals to the stack
        for (int j = i; j < n; j++) {
            int[] prev = stack.peek();
            // if there is conflict between the stack and next item in intervals
            if (intervals[j][0] <= prev[1] ) {
                prev[1] = Math.max(prev[1], intervals[j][1]);
            } else {
                stack.add(intervals[j]);
            }
        }

        return stack.toArray(new int[stack.size()][2]);

    }
    
}

/*
 * Solution1 Time complexity:
 * O(n)
 * 
 * Solution1 Space complexity:
 * O(n) as the new linkedlist can occupy extra memort for n elements stored 
 * 
 * 
 * 
 * Time complexity solution 2:
 * O(N) where N is the number of elements in the intervals
 * 
 * Space complexity solution 2:
 * O(N) N elemts are generated as output in the list
 */