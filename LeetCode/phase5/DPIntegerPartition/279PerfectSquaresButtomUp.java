class solution4 {

    public int numSquares(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 0;

        for (int num = 1; num <= n; num++) {
            cache[num] = Integer.MAX_VALUE;
            for (int i = 1; i*i <= num; i++) {
                cache[num] = Math.min(cache[num - (i*i)] + 1, cache[num]);
            }
        }
        return cache[n];
    }

}

/*
 * Time complexity:
 * 0(n*sqrt(n))
 * 
 * Space Complexity:
 * o(n), initializing cache with n number of 0;
 * 
 */