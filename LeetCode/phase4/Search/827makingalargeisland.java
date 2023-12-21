import java.util.*;

class Solution {

    HashMap<Integer,Integer> hm = new HashMap<>();
    int[][] directions = {{-1,0}, {0,1},{1,0},{0,-1}};
    int[][] grid;
    int m,n;
    int id;
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        id = -1;

        //Assing id to each Island and count 1s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int islandSize = dfs(i,j);
                    hm.put(id, islandSize);
                };
                id--;
            }
        }

        //Compare Islands and find the max size
        int maxIslandSize = 0;
        for (int id : hm.keySet()) maxIslandSize = Math.max(maxIslandSize, hm.get(id));

        //Flip a 0 if possible and calculate the final maxIsland size
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    int curMax = calMaxSize(i, j);
                    maxIslandSize = Math.max(maxIslandSize, curMax);
                }

            }
        }

        return maxIslandSize;
    }

    private int dfs(int row, int col) {
    
        //base
        if (row < 0 || row == m || col < 0 || col == n) return 0;
        //For items with 0 value or visited return 0
        if (grid[row][col] != 1) return 0;

        //Change value to id
        grid[row][col] = id;

            //DFS in 4 directions
            int top = dfs(row - 1, col);
            int right = dfs(row, col + 1); 
            int left = dfs(row, col - 1);
            int down = dfs(row + 1, col);

        return top + right + left + down + 1;
    }

    private int calMaxSize(int row, int col) {

        //Need a set to contain id of islands -in case of neighboring islands and a merge-
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int[] dir : directions) {
            int curRow = row + dir[0], curCol = col + dir[1];

            //base
            if (curRow < 0 || curRow == m || curCol < 0 || curCol == n) continue;
            if (grid[curRow][curCol] == 0) continue;

            set.add(grid[curRow][curCol]);
        }

        for (int islandId : set) {
            sum += hm.get(islandId);
        }
    
        return sum + 1;
    }
}

/*
Time complexity:
O(m*n)


Space complexity:
Recursive call stack DFS, hashMap (there can be mxn/2 = mxn Islands)
Worst case: O(m*n)

 * * * * * * * *
 1 1 * * * * 1 *
 * 1 1[*]1 * 1 * 
 * * * * 1 * 1 *
 * * * 1 1 1 * * 
 * 1 * 1 1 * * * 
 * 1 * 1 1 * 1 * 
 * * * * * * * * 
 
 Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 
Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
 */