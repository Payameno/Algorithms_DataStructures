
public class WordSearch {

    private static int[][] Drcs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist (char[][] board, String word) {

      if (board == null || board.length == 0) return false;

      for (int i=0; i<board.length;i++) {    
    
        for (int j=0; j<board[0].length; j++) {

          if (board[i][j] == word.charAt(0) && exist(board, word, 0, i, j)) return true;

        }
      }  

      return false;
    }

    private boolean exist (char[][] board, String word, int count, int i, int j) {

      if (count == word.length()) return true; 

      if (i == -1 || j == -1 || i == board.length || j == board[0].length || board[i][j] != word.charAt(count)) return false;

      //Mark cell as visited by setting its value as space which returns false in any subsequent search
      char temp = board[i][j];
      board[i][j] = ' ';
      boolean found = false;

      //Search
      for (int[] dir: Drcs) {
        if (exist(board, word, count+1, i+dir[0], j+dir[1])) {
          found = true;
          break;
        }
      }

      //unSelect
      board[i][j] = temp;

      return found;
    }

}

//char[][]
//[[],[],[]]
//stack or queue we need a queue here