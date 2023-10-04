class solution3 {

    Integer[] cache;
    public int numSquares(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {

        //Base Case
        if (n == 0) return 0;

        //Retrieve exisitng cache
        if (cache != null) return cache[n];

        //cache[n] is initialized as null, to compare set it as a large number
        cache[n] = Integer.MAX_VALUE;
        for (int i = 1; i*i <= n; i++) {
            cache[n] = Math.min(cache[n], dfs(n - (i*i) + 1));
        }

        return cache[n];
    }

}

/*

Time complexity:
O(sqrt(n)) exponential

Space complexity:
O(n) as we initialize cache with n+1 members

Perfect squares:
1,4,9,16,25,36,49,64,81,100

----------

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

dfs(12) -> 
1 + dfs(11) ...
4 + dfs (8) -> 4 + dfs(4) -> 4 => [3]
9 + dfs(3) ... 

----------

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104
*/