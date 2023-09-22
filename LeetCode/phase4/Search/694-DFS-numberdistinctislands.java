import java.util.*;

class solution  {

    final int water = 0, land = 1;
    int m, n, BaseRow, BaseCol;
    int[][] grid;

    public int numDistinctIslands(int[][] grid) {

        Set<String> shapes; = new HashSet();
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == water) continue;

                StringBuilder sb = new StringBuilder();

                BaseRow = row;
                BaseCol = col;

                dfs(row,col,sb);

                /*
                 * In Java, a HashSet is a collection that does not allow 
                 * duplicate elements, all elements are ensured to be unique
                 * Adding a repetitive set will not throw an exception, it is
                 * simply ignored
                 */

                shapes.add(sb.toString());

            }
        }

        //Return unique number of Islands
        return shapes.size();
    }

    private void dfs(int row, int col,StringBuilder sb) {

        //Base
        if (row < 0 || col < 0 || row == m || col == n) return;
        if (grid[row][col] == water) return;

        //Append coodinates of current position to sb ex: (0,0|)
        sb.append(row - BaseRow); // Automatically int is chnged to a string representation
        sb.append(","); //Delimiter - Optional
        sb.append(col - BaseCol);
        sb.append("|"); //Delimiter - Optional

        //sink this cell as water
        grid[row][col] = water;

        /*
         * DFS 4 directions
         */

        //Top
        dfs(row - 1, col, shapes);

        //Down
        dfs(row + 1, col, shapes);

        //Right
        dfs(row, col + 1, shapes);

        //Left
        dfs(row, col - 1, shapes);
    }
            
}
