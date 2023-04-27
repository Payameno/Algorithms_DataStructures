package W4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CoinChange {
  List<Integer> denominations = new ArrayList<>();
  int denomSize;
  
  public int coinChange(int[] coins, int amount) {
  
    if (amount==0) return 0;
    
    for (int i=0; i<coins.length;i++) {
      denominations.add(coins[i]);
    }

    denomSize = denominations.size();

    //Map existing results for a denominations
    //This will save calculation time
    Map<Integer,Integer> calculatedResults = new HashMap<Integer,Integer>();

    //Method call to populate maps
    return minCoinsUtil(amount, calculatedResults);

  }

  private int minCoinsUtil(int amount, Map<Integer,Integer> calculatedResults) {
      
    int result = Integer.MAX_VALUE;
    int smallerProblemResult;
    int candidateAnswer;
    int remainder;

    for (int coin : denominations) {
      if (amount == coin) {
        return 1;
      }
    }  
      //if coins used is already calculated for the amount
      if (calculatedResults.containsKey(amount)) {
        return calculatedResults.get(amount);
      }

    for (int i=0; i<denomSize; i++) {

      if(i == denomSize-1 && amount-denominations.get(i)!=0) return -1;

      if (amount>denominations.get(i)) {
        remainder = amount-denominations.get(i);

        smallerProblemResult = minCoinsUtil(remainder, calculatedResults);
        candidateAnswer = smallerProblemResult+1;

        if (candidateAnswer<result) {
          result = candidateAnswer;
          calculatedResults.put(amount, result);
        }

      }

    }

    calculatedResults.put(amount, result);
    return result;
  }

}

