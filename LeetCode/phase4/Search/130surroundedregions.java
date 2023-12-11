class Solution {

    //Define the parameters
    final char O = 'O';
    final char X = 'X';
    final char marked = '#';
    int m,n;
    char[][] board;

    public void solve(char[][] board) {

        this.board = board;
        m = board.length;
        n = board[0].length;

        //Visit the col borders
        for (int row = 0; row < m; row++) {
            dfs(row,0); // Left border col
            dfs(row, n - 1); // right border col
        }

        //Visit the row borders
        for (int col = 0; col < n; col++) {
            dfs(0, col);
            dfs(m - 1, col);
        }

        //Traverse the grid, flip the areas to their respective character
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == O) {
                    board[i][j] = X;
                } else if  (board[i][j] == marked) {
                    board[i][j] = O;
                }
            }
        }

    }

    private void dfs(int row, int col) {
        //Stop if moved out of the grid
        if (row < 0 || row == m || col < 0 || col == n) return;
        if (board[row][col] != O) return;

        //Temporarily change O to # to mark as visisted
        if (board[row][col] == O) board[row][col] = marked;

        //Recursively find sourranding area
        dfs(row + 1,col); // top
        dfs(row - 1,col); // bottom
        dfs(row,col + 1); // right
        dfs(row,col - 1); // left
    }

}

/*
Solutions:
An O character is not flipped under two condition, first it's on the border of grid
second it's a neighbor of a border O, therefore  we will find these border Os, mark them as #
The reason we do this is to avoid revisiting them in the recursive call stack
We have two column borders and two row borders 

After this we will have a nested loop to flip these O's back to O and the rest to X.
Input: board = [["X","X","X","X"],
                ["X","O","O","X"],
                ["X","X","O","X"],
                ["X","O","X","X"]]


 Time complexity:
 1) Traversing the col border O(m+n)
 2) Traversing the row border O(m+n)
 3) nested loop O(mxn)
Overal O(mxn)


 Space complexity:
 Recursive call from each border O(Max(m,n))
 the longest recursive call is gonna be the length of the larger length


Example 1:

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.


Example 2:
Input: board = [["X"]]
Output: [["X"]]
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.

 */