class Solution {
    public int maxProfit(int[] prices) {

      int len = prices.length;
      int maxProfit = 0;
      //base
      if (len < 2) return 0;

      int maxPrice = prices[len - 1];
      for (int i = len - 2; i >= 0; i--) {

        maxPrice = Math.max(prices[i], maxPrice);
        maxProfit = Math.max(maxProfit, maxPrice - prices[i]);

      } 

      return maxProfit;

    }
}

/*
Time complexity: O(n)
Space Complexity: o(1)

[7,6,6,6,6,4]
        <- ^ 
*/

