class KnapSackTopDown {

    int[] weight;
    int[] profits;
    //Cache is defined by the Integer class to allow null values
    Integer[][] cache;

    public KnapSackTopDown(int[] _profits, int[] _weight) {
        this.weight = _weight;
        this.profits = _profits;
    }

    public int solveKnapsack(int capacity) {
        cache = new Integer[weight.length][capacity+1];
        helper(0,0,capacity);
    }

    private int helper(int index, int curProfit, int capacity) {
        
        //base
        //If we reach the end of the decision tree, we return the calculated profit
        if (index >= weight.length) return curProfit;
        //If we go over the capacity we eliminate that path by returning 0
        if (capacity < 0) return 0;

        //recall value from cache if it exists
        if (cache[index][capacity] != null) return cache[index][capacity];


        int take = helper(index + 1, curProfit + profits[index], capacity - weight[index]);
        int skip = helper(index + 1, curProfit, capacity);

        //write values to cache
        cache[index][capacity] = Math.max(take,skip);
        return cache[index][capacity];
    };

}

/*

Top down approach as we are working our way down the items (with weights)

Time Complexity: O(n * capacity)

while initializing a single variable in Java takes constant time, 
initializing a two-dimensional array with specified dimensions takes time 
proportional to the product of those dimensions, which results in O(N * C) 
for the cache array.
Each item in this 2D array is initialized as null

Helper function is also called for each item with (0 - n-1) * (0 - Capacity + 1)
number of times (Time complexity O (n*Capacity))

Space Complexity: 
O(n * capacity) which belongs to populating cache
weight and profit take 0(n)

Overal space complexity is O(N* capacity)

*/