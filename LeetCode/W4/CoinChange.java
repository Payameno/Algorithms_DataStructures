package W4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class CoinChange {
  public int coinChange(int[] coins, int amount) {

    //Greedy algorithm
    if (amount == 0) return 0;

    //sort the coins in descending order (converting int array to object integer, sort, convert back )
    Integer[] coinsObj = Arrays.stream(coins).boxed().toArray(Integer[]::new);
    Arrays.sort(coinsObj, Comparator.reverseOrder());
    int[] coinsSorted = Arrays.stream(coinsObj).mapToInt(Integer::intValue).toArray();


      ArrayList<Integer> result = new ArrayList<>();
      int temp = amount;

      for (int coin : coinsSorted) {
        int remainder = temp%coin;

        if (temp>=coin) {
          result.add(temp/coin);
          temp = remainder;
        }
        if(temp == 0) {
          return result.size();
        }
      }
      return -1;
  }
}

/*
 * Input: coins = [1,2,5], amount = 11
*Output: 3
*Explanation: 11 = 5 + 5 + 1
*
*[1,2,5] => 2%1
*
*\
*
 */