class Solution {

    public int change(int amount, int[] coins) {
        int N = coins.length, A = amount;
        int[][] cache = new int[N][A + 1];

        //Write the values of the first row
        cache[0][0] = 1; // If the difference of 0 is achieved, one combination
        for(int col = 1; col <= A; col++){
            if(0 <= col - coins[0]){
                cache[0][col] = cache[0][col - coins[0]];
            }
        }

        //Evaluate the remainder of cache values
        for(int row = 1; row < N; row++){
            cache[row][0] = 1; //Write the value of the amount zero
            for(int col = 1; col <= A; col++){
                int take = 0;
                int skip = cache[row - 1][col];
                if(0 <= col - coins[row]){
                    take = cache[row][col - coins[row]];
                }
                int totalUniqueWays = skip + take;
                cache[row][col] = totalUniqueWays;
            }
        }
        return cache[N - 1][A];
    }

}

/*

Time Complexity:
O(N*A)

Space Complexity:
O(N*A)

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4

Solution:

Coins    idx    0   1   2   3   4   5   Amount
[1]       0   | 1 | 1 | 1 | 1 | 1 | 1 | Unique ways
[1,2]     1   | 1 | 1 | 2 | 2 | 3 | 3 | 
[1,2,5]   2   | 1 | 1 | 2 | 2 | 3 | 4 |
                            return  ^ 

Explanation: 
A coin can be used an infinite number of times.
We set the first row and column to 1 because when the difference is 0, there is 1 
combination. For the amount 2 with a 1 denomination, there is only one combination
[1,1].

there are four(4) ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1

Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
 
 */