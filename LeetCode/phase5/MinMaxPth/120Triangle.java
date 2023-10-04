import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution_Bottom_Up {

  /*
   * Botto-UP approach
   */

  public int minimumTotal(List<List<Integer>> triangle) {

    int size = triangle.size();
    for (int row = size - 2; row >= 0; row--) {

      List<Integer> curRow = triangle.get(row);
      List<Integer> perRow = triangle.get(row + 1);

      for (int col = 0; col < row + 1; col++) {
        //Calculate min sum
        int leftSum = perRow.get(col);
        int rightSum = perRow.get(col + 1);

        //Write min sum on current col
        curRow.set(col, Math.min(leftSum,rightSum)+ curRow.get(col));
      }
    }
    return triangle.get(0).get(0);
  }

}

/*
  BottomUp approach
 * Time complexity:
 * O(n) where n the number of nodes
 * 
 * Space compleixty:
 * O(1)
 * 
 */

class Solution_Top_Down {

  //DP SOlution

  List<List<Integer>> triangle;
  List<Map<Integer,Integer>> cache;

    public int minimumTotal(List<List<Integer>> triangle) {

      this.triangle = triangle;

      //Define cache
      cache = new ArrayList<>();
      for (int i = 0; i < triangle.size() - 1; i++) {
        cache.add(new HashMap<>());
      }

      return helper(0,0);
    }

    private int helper(int row, int col) {
      
      int curVal = triangle.get(row).get(col);

      //Base
      if (row == triangle.size() - 1) return curVal;

      //Cache check
      Map<Integer, Integer> map = cache.get(row);
      if (map.containsKey(col)) return map.get(col);

      //Find minimum Path
      int path1 = helper(row+1, col);
      int path2 = helper(row+1, col+1);

      //Map the computed sum
      map.put(col, Math.min(path1,path2) + curVal);
      return map.get(col);

    }
    
}

/*
  Top-Down Appraoch
 * Time complexity: O(2^n) exponensaial
 * 
 * Space Complexity: o(N^2)
 * O(N) space used for the call stack
 * O(N-1) space used for cache
 * Where N is the number of rows
 */

/*
 * 
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
   Output: 11
   Explanation: The triangle looks like:

      2
     3 4
    6 5 7
   4 1 8 3

   The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

   Greedy ALgorithm: To find locally the minimum number in each row and sum the up, the problem\
   arises from this approach when for example in the example above 7 is changed to 0.@interface
   In this scnario since 7 is not an adjancent number to 3 the row before, we might have the wrong
   total sum.

 */