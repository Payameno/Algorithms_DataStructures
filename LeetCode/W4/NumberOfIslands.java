package W4;

class NumberOfnumIslands {

  public int numIslands(char[][] grid) {

    if (grid==null || grid.length==0) return 0;

    int numIslands = 0;
    int numRows = grid.length;
    int numCols = grid[0].length;

    for (int i=0; i<numRows; i++) {
      for (int j=0; j<numCols; j++) {
        
        if (grid[i][j]=='1') {
          numIslands++;
          dfs(grid,i,j,numRows, numCols);
        }

      }
    }
    
    return numIslands;
  }

 private void dfs(char[][] grid, int i, int j, int numRows, int numCols) {

    if(i>=numRows || i<0 || j>=numCols || j<0 || grid[i][j]=='0') {
      return;
    }
      grid[i][j] = '0';

      dfs(grid, i+1, j, numRows, numCols);
      dfs(grid, i-1, j, numRows, numCols);
      dfs(grid, i, j+1, numRows, numCols);
      dfs(grid, i, j-1, numRows, numCols);

  }

}
