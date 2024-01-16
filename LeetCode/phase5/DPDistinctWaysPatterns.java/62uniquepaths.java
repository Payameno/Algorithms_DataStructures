import java.util.*;

class Solution {

    public int uniquePaths(int m, int n) {
        /*Create cache to record the number of ways it takes to get to
        the point for the following cell
        */
        int[][] cache = new int[m][n];

        //Set initial values as 1 for all cells
        for (int[] row : cache) {
            Arrays.fill(row, 1);
        }

        //A nested loop to find and rewrite values
        for (int i = m - 2; 0 <= i; i--) {
            for (int j = n - 2; 0 <= j; j--) {
                int bottom = cache[i + 1][j];
                int right = cache[i][j + 1];
                //For the current cell the total number of ways is the sum of bottom and right 
                cache[i][j] = bottom + right;
            }
        }
        return cache[0][0];
    }

}

/*
 Time complexity:
 O(mxn)
 
 Space complexity:
 O(mxn)


| 2 | 1 | 
 -------
| 1 | 1 |
 -------
 */