class Solution {

    int[] cache;
    public int numTrees(int n) {
        cache = new int[n + 1];
        return helper(n);
    }

    private int helper(int n) {
        if (n < 2) return 1;

        if (cache[n] != 0) return cache[n];

        int total = 0;
        for (int i = 1; i <= n; i++) {
            int leftN = helper(i - 1);
            cache[i - 1] = leftN;
            int rightN = helper(n - i);
            cache[n - i] = rightN;
            total += (leftN * rightN);
        } 
        return total;
    }

}

/*
 Time complexity:

 Space complexity:


 */