import java.util.*;

class solution  {

    final int water = 0, land = 1;
    final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n, baseRow, baseCol;
    int[][] grid;

    public int numDistinctIslands(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = gird[0].length;
        Set<String> shapes = new HashSet<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                
                if (grid[row][col] == water) continue;
                
                    baseRow = row;
                    baseCol = col;
                    StringBuilder sb = new StringBuilder();
                    bfs(row,col,sb);
                    shapes.add(sb.toString());

            }
        }
        return shapes.size();
    }

    private void bfs(int row, int col, StringBuilder sb) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row,col});
        
        //Sink this cell of land to avoid recount
        grid[row][col] = water;

        while(!queue.isEmpty()) {

        //Get the current position
        int[] curPos = queue.poll();

        //Add currnt position coordinates
        sb.append(curPos[0] - baseRow);
        sb.append(curPos[1] - baseCol);

        //Check the neighbors in 4 direction
        for (int[] direction : DIRECTIONS) {

            int curRow = direction[0] + curPos[0];
            int curCol = direction[1] + curPos[1];

            if(validate(curRow,curCol)) {
                queue.add(new int[] {curRow, curCol});
                grid[curRow][curCol] = water;
            }
        }

        }

    }

    private boolean validate(int row, int col) {
        if (row < 0 || col < 0 || row == m || col == n) return false;
        if (grid[row][col] == water) return false;
        return true;
    }
            
}
