package phase5.DPDistinctWaysPatterns.java;

class Solution {
    public int climbStairs(int n) {
        if (n < 4) return n; // n = 1 output = 1, n=2 op=2, n=3 op=3.

        int prevStep1 = 3, prevStep2 = 2, curStepWays = 0;
        for (int i = 4; i <= n; i++) {
            curStepWays = prevStep1 + prevStep2;
            prevStep2 = prevStep1;
            prevStep1 = curStepWays;
        }
        return curStepWays;
    }
}

/*
Note:
For a problem to exhibit a Fibonacci sequence-like nature, 
it doesn't necessarily have to exactly follow the Fibonacci sequence. 
Instead, it might share the characteristic of solutions being calculated 
based on previous solutions in a systematic way.


 Time complexity:
 The solution iterates from n = 4 to n, therefore O(n)

 Space complexity:
 O(1) constnat
 
 */