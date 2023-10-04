package DPIntegerPartition;

class solution {
    Integer[] cache;
    public int integerBreak(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        
        //Max Product for: 0 -> 0, 1 -> (0x1) = 0
        if (n < 2) return 0;

        //Retrieve exisiting cache
        if (cache[n] != null) return cache[n];

        /*Perform dfs
        Example 4 ->  1 - 1 - 1 - 1 (maxProduct 1) 
        Or 1 - 1 - 2  (maxProduct 2)
        Or 2 - 2 (4)
        Or 1 - 3 (3)
        */

        int maxProductN = 0;
        for (int i = 1; i < n; i++) {
            int curMaxProduct = Math.max(n - i, dfs(n - i));
            maxProductN = Math.max(maxProductN, i * curMaxProduct);
        }
        cache[n] = maxProductN;

        return maxProductN;
    }
  
}

/*
Time Complexity: O(n^2) There are n subProblems and for each n=1 to n-1 iterations

Space Complexity: O(n) Initilizing cache with n values
*/
