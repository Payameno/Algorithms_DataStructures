class Solution {

    char[][] matrix;
    Integer[][] cache;
    int maxWidth;
    int M;
    int N;

    //Top Down method

    public int maximalSquare_Top_Down(char[][] matrix) {
        this.matrix = matrix;
        this.M = matrix.length;
        this.N = matrix[0].length;
        this.cache = new Integer[M][N];
        this.maxWidth = Integer.MIN_VALUE;

        //Call the recursive method to calculate maxWidth;
        helper(0,0);

        //Calculate the area
        return maxWidth * maxWidth;  
    }

    private int helper(int row, int col) {

        //Base
        if (row >= M || col >= N) return 0;

        //Cache Retrieval
        if (cache[row][col] != null) return cache[row][col];

        int curWidth = convertInt(matrix[row][col]);
        //Move in 3 directions
        int right = helper(row, col + 1);
        int down = helper(row + 1, col);
        int downRight = helper(row + 1, col + 1);

        
        int minWidth = Math.min(right, Math.min(down, downRight));

        //If current c
        if (curWidth == 1) {
            curWidth += minWidth;
        }
        cache[row][col] = curWidth;

        //Update max width
        maxWidth = Math.max(maxWidth, curWidth);
        return curWidth;
    }

    private int convertInt(char character) {
        if (character == '1') return 1;
        return 0; 
    }

    //Bottom Up Method

    public int maximalSquare_Bottom_Up(char[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] cache = new int[M + 1][N + 1];
        int maxWid = 0;

        //Nested loop to traverse cells
        for (int row = 1; row < M + 1; row++) {
            for (int col = 1; col < N + 1; col++) {

                if (matrix[row - 1][col - 1] == '1') {
                    int top = cache[row - 1][col];
                    int topLeft = cache[row - 1][col - 1];
                    int left = cache[row][col - 1];

                    int min = Math.min(top, Math.min(topLeft, left));
                    cache[row][col] = min + 1;

                    //Update the Maxwidth
                    maxWid = Math.max(maxWid, cache[row][col]);
                }

            }
        }
        return maxWid * maxWid;
    }

    public int maximalSquare_Bottom_Up_Optimized (char[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[] prev = new int[N + 1], cur = new int[N + 1];
        int maxWid = 0;

        //Nested loop to traverse cells
        for (int row = 1; row < M + 1; row++) {

            for (int col = 1; col < N + 1; col++) {

                if (matrix[row - 1][col - 1] == '1') {

                    int top = prev[col];
                    int topLeft = prev[col - 1];
                    int left = cur[col - 1];

                    int min = Math.min(top, Math.min(topLeft, left));
                    cur[col] = min + 1;

                    //Update the Maxwidth
                    maxWid = Math.max(maxWid, cur[col]);

                }

            }
            // Swap cur and prev arrays for the next row.
            prev = cur;
            cur = new int[N + 1];
        }
        return maxWid * maxWid;
    }

}

/*

**Top Down Approach**

The calculated maxWidth for each cell is recorded in the cache

Time Complexity:
O(MXN)

Space Complexity:
O(M*N)

**Bottom Up Approach**

    Current cell will be calculated using cache

    Example:
    1 1
    1 1

    Cache definition
    0 0 0
    0 1 1
    0 1 2

    Step (1):
    maxVal = 0
    (2)
    maxVal = 1
    (4)
    maxVal = 2


Time Complexity:
O(m*n)

Space Complexity:
O(m*n)


    Bottom Up Optimized

    Cache definition
    M = 2, N = 2

    Define a row of size M + 1 called prev
    || N + 1called cur

    0 0 0 
    0 1 1 pre

    0 - - cur


Time complexity:
o(N*M)

Space complexity:
Optimized O(N)

*/