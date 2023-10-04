class Solution {
    public int maxProfit(int[] prices) {

        //Keep track of the min value
        int minPrice = Integer.MAX_VALUE;
        
        int maxProfit = 0;

        //Keep track of the sum of the profits
        int sum = 0;

        for (int num : prices) {
            minPrice = Math.min(minPrice, num);
            maxProfit = num - minPrice;

            if(maxProfit > 0) {
                sum += maxProfit;
                maxProfit = 0;
                minPrice = num;
            }
        }
        return sum;
    }
}

/*
Time complexity: O(n)
Space Complexity: o(1)

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
*/