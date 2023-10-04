class Solution {

    int m, n;
    public int[] findDiagonalOrder(int[][] mat) {

        m = mat.length;
        n = mat[0].length;
        int[] res = new int[m * n];

        //Traversal Coordinates
        int row = 0, col = 0, index = 0;

        while (row < m && col < n) {

            res[index++] = mat[row][col];
            boolean traversUp = (row + col) % 2 == 0;

            if (traversUp) {

                if (withinBoundary(row - 1,col + 1)) {
                    row--;
                    col++;
                } else if (withinBoundary(row,col + 1)) {
                    col++;
                } else {
                    row++; 
                }

            } else {

                if (withinBoundary(row + 1,col - 1)) {
                    row++;
                    col--;
                } else if (withinBoundary(row + 1,col)) {
                    row++;
                } else {
                    col++;
                }

            }
        }

        return res;
    }

    private boolean withinBoundary(int x, int y) {
        if (x < 0 || m <= x) return false;
        if (y < 0 || n <= y) return false;
        return true;
    }
}