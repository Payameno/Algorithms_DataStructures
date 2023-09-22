class Solution {

  final char water = '0';
  final char land = '1';
  int m,n;
  char[][] grid;
  
  public int numIslands(char[][] grid) {
    
    int res = 0;
    this.grid = grid;
    m = grid.length;
    n = grid[0].length;

      //nested loop to check each cell
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

          if (grid[i][j] == land) {
          //add one to number of Islands
          res++;

          //size the Island up
          searchSurroundingIslands(i,j);
          }


        }
      }

      return res;
      
    }

    private void searchSurroundingIslands(int i, int j) {

      //base
      if (i < 0 || i == m || j < 0 || j == n) return;
      if (grid[i][j] == water) return;

      //Set land as water to exclude from future search
      grid[i][j] = water;

      //top dsf
      searchSurroundingIslands(i-1,j);
      //Right
      searchSurroundingIslands(i,j+1);
      //left
      searchSurroundingIslands(i,j-1);
      //bottom
      searchSurroundingIslands(i+1,j);
    }
}

/*
 * Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
  ]
   Output: 3
 */