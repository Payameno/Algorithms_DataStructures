class Solu {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    int printTimes = 30;

    public static void main(String[] args) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };;

        Solu sln = new Solu();
        sln.solveSudoku(board);

    }

    private char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        helper(0,0);
    }

    //Recursive method with use of backtracking to fill the gaps
    private boolean helper(int row, int col) {

        //Base case: Move to the next row if we reach the last col
        if (col == 9) {
            row = row + 1;
            col = 0;
        }

        //Base Case: If we reach the last row, the Sukodu is solved
        if (row == 9) return true;

        //If the cell is pre-filled, move to the next cell
        if (board[row][col] != '.') {
            return helper(row, col + 1);
        }

        for (char i = '1'; i <= '9'; i++) {
            //Check if current character conforms to the rules of the game
            if (!isValid(row, col,i)) continue; 


            //If current character is valid, make a decison
            board[row][col] = i;
            printBoard("A decision made", row, col);

            //With this decision made, move to the next cell
            if (helper(row, col+1)) return true;

            //If these entry at this recursion stack does not meet conditions,backtrack
            board[row][col] = '.';
            printBoard("Unchoose a decision", row, col);
        }

        //If no valid decision is found backtrack to the previous decision
        return false;
    } 

    private boolean isValid(int row, int col, char cur) {

        //Check the validity of the character in the row, col
        for (int i = 0; i <= 8; i++) {
            if (board[i][col] == cur) return false; //row cheked
            if (board[row][i] == cur) return false; //col checked
        }

        /*In order to check if the digit is not used in the 3x3 square:
         * 1- First find the border of current point (which square it belongs)
         * 2- Check the borders of that sqaure to make sure this digit is not used
        */

        int[] rowBorder = findBorder(row);
        int[] colBorder = findBorder(col);

        //Nested loop to check the square where the point belongs to
        for (int i = rowBorder[0]; i <= rowBorder[1]; i++) {
            for (int j = colBorder[0]; j <= colBorder[1]; j++) {
                if (board[i][j] == cur) return false;
            }
        }
        return true;
    }

    private int[] findBorder(int coor) {
        int[] res = new int[2];

        if (coor < 3) {
            res = new int[]{0,2};
        } else if (coor < 6) {
            res = new int[]{3,5};
        } else if (coor < 9) {
            res = new int[]{6,8};
        }
        
        return res;
    }

    private void printBoard(String message, int row, int col) {

        if (printTimes == 0) return;

        System.out.println(message);
        System.out.println(ANSI_RED + "------------------" + ANSI_RESET);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == row && j == col) {
                    System.out.print(ANSI_RED + "" + board[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print(board[i][j] + " ");
                }
                if (j == 2 || j == 5) {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
    }

}

/*
 Time complexity:
The worst-case time complexity is still (9^81)
which is a large but finite number (81 cells to fill, each with 9 possibilities).
In practice, the algorithm often performs much better than this worst-case scenario.

 Space complexity:
The space complexity is O(1) because the extra space used by the algorithm 
does not depend on the size of the input (Sudoku grid). 


 Example 1:
Input: board = [
["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]
]

Output: 
[
["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]
]

Explanation: The input board is shown above and the only valid solution is 
shown below:

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
 
 */