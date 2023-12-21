import java.util.*;

class Solution {

    int[][] grid;
    boolean[][] visited;
    Queue<int[]> q = new LinkedList<>();
    //The order of directions are important to find the shortest path
    final int[][] directions = {{1,1}, {1,0}, {1,-1}, {0, 1}, {0, 0}, {0,-1}, {-1, 1}, {-1, 0}, {-1, -1}};;
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        //Base case
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        this.grid = grid;
        visited = new boolean[n][n];
        int count = 1;
        q.add(new int[]{0,0}); //Add the starting position to the queue
        
        while (!q.isEmpty()) {

            /*BFS Approach, adding neighbors and finding the shortest path
            */
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curPos = q.poll();
                int row = curPos[0], col = curPos[1];

                //If destination is reached, return the count
                if (row == n - 1 && col == n - 1) return count;

                //Check the neighbors
                checkNeighbors(row, col);
            }

            count++;
        }
        return -1;
    }

    private void checkNeighbors(int row, int col) {

        int n = grid.length;
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];

            //It is not out of bound
            if (newRow < 0 || newRow == n || newCol < 0 || newCol == n) continue;
            //It is not visites
            if (visited[newRow][newCol]) continue; //If visisted continue
            //It is not 1
            if (grid[newRow][newCol] == 1) continue; //if the amount if 1 cannot be in the path


            //Add to the queue & set this cell as visited
            visited[newRow][newCol] = true;
            q.add(new int[]{newRow,newCol});
        }

    }

}

/*
 * Time complexity:
 * O(N) where N is the number of items in the grid
 * In the worst case, each item is added to the queue, for each item neighbors in 8 directions
 * are searched using the neighbors method.
 *  Explanation: N = n^2 where n is the length of the grid
 * 
 * Space complexity:
 * O(N) where N = n^2
 * Main contributors are queue & boolean visited array (nxn)
 * 
Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 */