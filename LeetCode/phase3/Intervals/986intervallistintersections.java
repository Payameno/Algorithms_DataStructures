import java.util.*;

class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        //Define a stack to storer results (Arraylist or LinkedList can also be used)
        Stack<int[]> stack = new Stack<>();
        
        //Define the pointers and lists length
        int p1 = 0, n1st = firstList.length, p2 = 0, n2nd = secondList.length;

        //Iterate through the list, find conflict,2 items compared at a time hence while condition
        while (p1 < n1st && p2 < n2nd) {
            int[] p1Interval = firstList[p1];
            int[] p2Interval = secondList[p2];

            if (isInConflict(p1Interval, p2Interval)) {
                int start = Math.max(p1Interval[0], p2Interval[0]);
                int end = Math.min(p1Interval[1],p2Interval[1]);
                int[] interval = {start, end};
                
                //Add to stack
                stack.add(interval);
            }

            /*
            Move pointers: pointer with the smallest end time moves
            This is mainly because intervals are disjoint here
            p1 = [0,2] [start will be equal or greater than 2 which can get it in conflict with p2e]
            p2 = [0,3] 

            That makes the one with the smaller value a candidate to move
            */
            if (p1Interval[1] < p2Interval[1]) {
                p1++;
            } else {
                p2++;
            }
        }

        return stack.toArray(new int[stack.size()][2]);
    }

    private boolean isInConflict(int[] p1Interval, int[] p2Interval) {
        //Example: p1I = [0,2] p2I = [1,4] p1 second element in conflict
        if (p2Interval[0] <= p1Interval[1] && p1Interval[1] <= p2Interval[1]) return true;
        //Example: p1I = [5,10] p2I = [1,5] p1 first element in conflict
        if (p2Interval[0] <= p1Interval[1] && p1Interval[0] <= p2Interval[1]) return true;

        return false;
    }

}

/*
 Time complexity:
 M = length of the first list
 N = Length of the second list
 H = smaller length
 O(H)

 Space complexity:
 O(H) where H is the size of stack (number of intersections)
 

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]]
                                    p1
      secondList = [[1,5],[8,12],[15,24],[25,26]]
                                   p2

Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
 
Constraints:

0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109 
endj < startj+1

 */