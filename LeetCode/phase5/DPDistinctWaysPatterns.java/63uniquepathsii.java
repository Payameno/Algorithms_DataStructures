import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        //A cache to maintain the count of paths in current cell
        int[][] cache = new int[m + 1][n + 1];

        //Nested loop to traverse the grid from bottom-right to top-left
        for (int i = m - 1; 0 <= i; i--) {
            for (int j = n - 1; 0 <= j; j--) {
                //If this cell is an obstacle, continue (remains value of 0 in cache)
                if (obstacleGrid[i][j] == 1) continue;

                //if we are at the bottom-right cell write as 1
                if (i == m - 1 && j == n - 1) {
                    cache[i][j] = 1;
                } else {

                    int bottom = cache[i + 1][j]; 
                    int right = cache[i][j + 1];
                    cache[i][j] = bottom + right;

                }

            }
        }
        return cache[0][0];
    }
}

/*

Time complexity:
O(m*n)
Space complexity:
O(m*n)

Note:1's are considered an obstacle in this problem
 Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 
 */