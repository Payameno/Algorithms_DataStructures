class CountSubsetSumTopDown {
    
    int[] arr;
    Integer[][] cache;

    public CountSubsetSumTopDown(int[] input) {
        this.arr = input;
    }

    public int solveCountSubsetSumTopDown(int num) {
        cache = new Integer[arr.length][num + 1];
        return helper(0, num);
    }

    private int helper(int idx, int curSum) {

        //Base case
        if (curSum == 0) return 1;
        if (curSum < || idx < 0) return 0;
        
        //Retrieve cache
        if (cache[idx][curSum] != null) return cache[idx][curSum];

        int take = helper(idx + 1, curSum - arr[idx]);
        int skip = helper(idx + 1, curSum);

        cache[idx][curSum] = take + skip;
        return cache[idx][curSum];

    }
}

public void main(String[] args) {

    CountSubsetSumTopDown test1 = new CountSubsetSumTopDown(new int[]{1,2,7,1,5});
    test1.solveCountSubsetSumTopDown(9); // <- expected 3

}

/*
        
         * Input: values = [1, 1, 2, 3] sum = 4
         * 
         * Output: 3
         * 
         *  
         * arrIdx/ sum  0   1   2   3   4
         *    0                         
         *    1
         *    2
         *    3
         *
         * 
         * 
         * 
         * Time complexity:
         * 
         * O(n*num)
         * 
         * Space complexity:
         * O(n*num)
         * 
*/