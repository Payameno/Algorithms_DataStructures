class Solution {

    public int numTrees(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 1;
        cache[1] = 1;

        for (int curN = 2; curN <= n; curN++) {
            int total = 0;
            for (int curNum = 1; curNum <= curN; curNum++) {
                int leftNodes = curNum - 1;
                int leftTotalBST = cache[leftNodes];
                int rightNodes = curN - curNum;
                int rightTotalBST = cache[rightNodes];
                total += (leftTotalBST * rightTotalBST);
            }
            cache[curN] = total;
        }
        return cache[n];
    }

}

/*
 Time complexity:

 Space complexity:


Example 1:
Input: n = 3
Output: 5

Example 2:
Input: n = 1
Output: 1
 

Constraints:
1 <= n <= 19
 */