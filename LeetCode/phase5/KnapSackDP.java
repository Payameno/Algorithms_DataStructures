public class KnapSackDP {

  int[] weight;
  int[] profits;

  public KnapSackDP(int[] weight, int[] profits) {
    this.weight = weight;
    this.profits = profits;
  }

  //Dynamic programming
  public int KnapSack(int capacity) {

    //define cache - Default value is 0
    int[][] cache = new int[profits.length][capacity + 1];

    //Fill values for the first row
    for (int i = 1; i < capacity; i++) {

      int curCapacity = i;
      if(weight[0] <= curCapacity) {
        cache[0][i] = profits[0];
      }

    }

    //nested loop to find the remainder capacity of cells
    for (int i = 1; i < cache.length; i++) {
      for (int j = 1; j < cache[0].length; j++) {

        int skip = cache[i-1][j];
        int take = 0; //initialized as 0

        int curCapacity = j;
        if (weight[i] <= curCapacity) {
          take = profits[i] + cache[i-1][curCapacity - weight[i]];
        }

        cache[i][j] = Math.max(take, skip);

      }
    }

    return cache[cache.length -1][capacity];

  }

  public static void main(String[] args) {
    
         /**
         * Input: values = [1, 6, 10, 16] weights = [1, 2, 3, 5] maxWeight = 7
         * 
         * Output: 22
         */
        KnapsackDP test0 = new KnapsackDP(new int[] { 1, 6, 10, 16 }, new int[] { 1, 2, 3, 5 });
        System.out.println(test0.solveKnapsack(7));// <--- expect 22
        /**
         * Input: values = [60, 50, 70, 30] weights = [5, 3, 4, 2] maxWeight = 8
         * 
         * Output: 120
         */

        KnapsackDP test1 = new KnapsackDP(new int[] { 60, 50, 70, 30 }, new int[] { 5, 3, 4, 2 });
        System.out.println(test1.solveKnapsack(8));// <--- expect 120

        /**
         * Input: values = [60, 100, 120, 80, 30] weights = [10, 20, 30, 40, 50]
         * maxWeight = 400
         * 
         * Output: 390
         */
        KnapsackDP test2 = new KnapsackDP(new int[] { 60, 100, 120, 80, 30 }, new int[] { 10, 20, 30, 40, 50 });
        System.out.println(test2.solveKnapsack(400));// <--- expect 390

  }
}

/*
 *   Input: values = [60, 100, 120] weights = [7, 8, 10]
 *   Capacity = 10
 *   
 * 
 *  Profits  Weight  Index   Cap 0 1 2 3 4 5 6 7 8 9 10
 *    60       7       0       [0,0,0,0,0,0,0,60,60,60,60]
 *   100       8       1       [0,0,0,0,0,0,0,0,0,100 + 0,100 + 0]
 *   120       10      2       [0,0,0,0,0,0,0,0,0,0,<120>]
 * 
 * 
 *  Time complexity = O(nxc) where n is the number of values and c is the capacity 
 *  (nested loop and each item is visisted once)
 */