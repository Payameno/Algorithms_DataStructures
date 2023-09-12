import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public int[][] merge(int[][] intervals) {

      //base
      if (intervals.length == 1) return intervals;

      //Sort the intervals based on the starting time
      Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

      //Create a stack
      Stack<int[]> stack = new Stack<>();
      
      //add the first interval into stack
      stack.add(intervals[0]);

      //Compare and possibly merge

      //retrieve the top element
      for (int i = 1; i < intervals.length; i++) {

       int[] pre = stack.peek();
       int[] cur = intervals[i];

        
        if (cur[0] > pre[1]) {
          stack.add(cur);
        } else {
          pre[1] = Math.max(pre[1], cur[1]);
        }
        
      }

      //return result
      /*
       * Java arrays require a fixed size when created
       * That is why it is necessary to specify the size of 
       * the resulting array from stack regardless of the content
       * inside the stack
       */
      return stack.toArray(new int[stack.size()][2]);

    }

}

/*
 * Input: intervals = [[1,3],[2,6],[8,10],[11,18]]
   Output: [[1,6],[8,10],[15,18]]

   Possible overlapping scenarios:
   a = [a1, a2];
   b = [b1, b2];

   1) a1<b1 && a2 > b2  -> This means b is a range inside a
   2) a2 > b1 -> overlapping, merge
   3) a1 > b2 && b2 > a2 -> a a range inside b

   Time complexity:
   Supposed there are n items inside the intervals
   O(n) as there is a loop of n iterations 

   Space complexity:
   O(1)

 */