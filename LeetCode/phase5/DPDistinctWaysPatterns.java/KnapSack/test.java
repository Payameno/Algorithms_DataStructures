class KnapsackDynamicP {
    int[] weight;
    int[] profit;
    int[][] cache;

    //Constructor
    public KnapsackDynamicP (int[] _weight, int[] _profit) {
        this.weight = _weight;
        this.profit = _profit;
    }

    public int KnapsackSolve(int capacity) {
        //Define cache, default value is 0
        cache = new int[weight.length][capacity + 1];

        //write the values of first item
        for (int i = 1; i <= capacity; i++) {
            int curCapacity = i;
            if (weight[0] <= curCapacity) {
                cache[0][i] = profit[i];
            }
        }

        //Write the rest of the grid using previous cell results
        for (int i = 0; i < cache.length; i++) {
            for (int j = 1; j <= capacity;j++) {
                int curCapacity = j;

                int skip = cache[i-1][j];
                int take = 0;  //take initialized as zero

                if (weight[i] <= curCapacity) {
                    take = profit[i] + cache[i-1][curCapacity - weight[i]];
                }

                cache[i][j] = Math.max(take,skip);
            }
        }

        return cache[cache.length -1][capacity];
    }

}

public static void main(String[] args) {
    KnapsackDynamicP test1 = new KnapsackDynamicP(new int[]{1,2,3,4}, new int[]{2,5,6,12});
    System.out.println(test1.KnapsackSolve(7));
}