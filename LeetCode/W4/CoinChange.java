
import java.util.Arrays;
class CoinChange {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp, amount+1);
    dp[0] = 0;
    for (int c:coins) {
      for (int i=c; i<=amount; i++) {
        dp[i] = Math.min(dp[i], dp[i-c]+1);
      }
    }

    return dp[amount]<=amount? dp[amount] : -1;
  }

}


/*
 * 1 Coin          2 coin             5 coin  
dp[0] = 0        

dp[1] = 1         
dp[2]            dp[2] = 1
dp[3]            dp[3] = 2
d p[4]           dp[4] = 2
dp[5]            dp[5] = 3                  dp[5] = 1 
dp[6]            dp[6] = 3                  dp[6] = 2
dp[7]            dp[7] = 4
dp[8]            dp[8] = 4  
dp[9]            dp[9] = 5
dp[10]           dp[10] = 5 
dp[11] = 11      dp[11] = 6                dp[11] = 3 
dp[12] = 12
 */