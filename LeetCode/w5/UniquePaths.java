public class UniquePaths {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m+1][n+1];

    return helper(0,0,m,n,dp);
  }

  private int helper (int i, int j, int m, int n, int[][] dp) {
   
    if(i>=m || j>=n) {
      return 0;
    }

    if(dp[i][j] != 0) {
      return dp[i][j];
    }

    if(i==m-1 && j==n-1) {
      return 1;
    }

    int r = helper(i, j+1, m, n, dp);
    int d = helper(i+1, j, m, n, dp);
    
    return dp[i][j] = d+r;
  }

}
