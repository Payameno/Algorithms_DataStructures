class Solution_Top_Down1 {

    int[][] grid;
    Integer[][] cache;
    int M;
    Int N;

    public int minPathSum(int[][] grid) {

        M = grid.length;
        N = grid[0].length;

        //Initialize cache
        this.grid = grid;
        cache = new Integer[M][N];

        return recDFS(0,0);
        
    }

    private recDFS(int row, int col) {

        //Base case
        if (row >= M -1 || col >= N -1) return Integer.MAX_VALUE;

        //Reached bottom-right
        if (row == M - 1 && col == N - 1) return grid[row][col];

        //Cache retrieval
        if (cache[row][col] != null) return cache[row][col];

        //Possible paths
        int right = recDFS(row,col + 1);
        int down = recDFS(row + 1, col);

        cache[row][col] = Math.min(right,down) + grid[row][col];
        return cache[row][col];
    }
}

class Solution_Bottom_Up {

    public int minPathSum(int[][] grid) {

        int M = grid.length, N = grid[0].length;
        int[][] cache = new int[M][N];

        //Initialize the first element in cache
        cache[0][0] = grid[0][0];

        //Build one step move output for the first row
        for (int col = 1; col < N; col++) {
            cache[0][col] = cache[0][col - 1] + grid[0][col];
        }

        for (int row = 1; row < M; row++) {
            //Build one step move output for the first col
            cache[row][0] = cache[row - 1][0] + grid[row][0];

            //Calculate the remainder elements
            for (int col = 1; col < N; col++) {
                int top = cache[row - 1][col];
                int left = cache[row][col - 1];
                cache[row][col] = Math.min(top,left) + grid[row][col];
            }
        }
        return cache[M - 1][N - 1];
    }

}

/*

Top_Down Approach:

Time Complexity:
Without cache = exponensial O(2^M*N) - each recursive call has two options to take
With cache = O(M*N) - already calculated paths will be retrieved from cache

Space Complexity:
O(N*M) Initliazing Cache with null values

Bottom_Up Approach:

Time complexity:
O(M*N)

Space complexity:
O(M*N)

*/