import java.util.*;

class Solution {

    int[][] heights;
    int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        List<List<Integer>> res = new LinkedList<>();

        //Pacific table definition
        boolean[][] pacificTable = new boolean[m][n];
        iterateRow(pacificTable, 0);
        iterrateCol(pacificTable, 0);


        //Atlantic table definition
        boolean[][] atlanticTable = new boolean[m][n];
        iterateRow(atlanticTable, m - 1);
        iterrateCol(atlanticTable, n - 1);

        //Compare both grids, add cells with both "True" values to res
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificTable[i][j] == true && atlanticTable[i][j] == true) {
                    res.add(Arrays.asList(new Integer[] {i, j}));
                }
            }
        }
        return res;
    }

    private void dfs(int row, int col, boolean[][] table) {

        /*
        Traverse four directions from cell, set as true if conditions passed
        */

        //Set as visisted
        table[row][col] = true;

        int curVal = heights[row][col];

        //Top - Implementation for the Atlantic ocean
        if (0 <= row - 1 && curVal <= heights[row - 1][col] && table[row - 1][col] == false) {
            dfs(row - 1, col, table);
        }

        //Dowm - Implementation for the Pacific
        if (row + 1 < m && curVal <= heights[row + 1][col] && table[row + 1][col] == false) {
            dfs(row + 1, col, table);
        }

        //Left - Implementation for the Atlantic
        if (0 <= col - 1 && curVal <= heights[row][col - 1] && table[row][col - 1] == false) {
            dfs(row, col - 1, table);
        }

        //Right  - Implementation for the Pacific
        if (col + 1 < n &&  curVal <= heights[row][col + 1] && table[row][col + 1] == false) {
            dfs(row, col + 1, table);
        }
    }

    private void iterateRow(boolean[][] table, int row) {
        for (int j = 0; j < n; j++) {
            dfs(row, j, table);
        }
    }

    private void iterrateCol(boolean[][] table, int col) {
        for (int i = 0; i < m; i++) {
            dfs(i, col, table);
        }
    }

}

/*

Problem:
Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes 
that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
oceans.

Solution:
Two tables will be defined, one for the Pacific and one for Atlantic
cells which mark as True have a path to their respective ocean
the result will be the comparison of both tables, for cells which match as
true for both, they are going be the coordinates that pass the contraints


 Time complexity:
 O(m X n)

- DFS Calls for Pacific Table O(m+n)
Each cell in the first row and first column is visited once.
- DFS Calls for Atlantic Table O(m+n)
Each cell in the last row and last column is visited once.
- DFS Calls for Comparison and Result Construction O(m×n)
Each cell in the grid is checked for both Pacific and Atlantic conditions.


 Space complexity:
 O(mxn) growth rate
 
 O(mxn(p table) + mxn(atl table) + Max(m,n)(recursive call stack)) = O(mxn)

 Example 1:

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.


Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105

 */