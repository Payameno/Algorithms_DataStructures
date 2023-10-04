class solution2 {

    //Bottom Up Apprcoach

    Integer[] cache;

    public int integerBreakBottomUp(int n) {
        cache = new Integer[n + 1];

        //Bottom Max Product
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;

        for (int num = 3; num <= n; num++) {
            for (int i = 1; i < num; i++) {
                int curMaxProduct = Math.max(num - i, cache[num - i]);
                cache[n] = Math.max(curMaxProduct * i, cache[n]);
            }
        }
        return cache[n];
    }

}

/*
Time complexity:
O(n^2) Iteration to the top, coupled with an iteration to the subproblem

Space Complexity: O(n)

*/