public class CountSubsetSumBruteForce {

    int[] arr;

    public CountSubsetSumBruteForce(int[] inputArr) {
        this.arr = inputArr;
    }

    public int solveCountSubsetSum(int sum) {
        return helper(0, sum);
    }

    private int helper(int index, int curSum) {

        if (curSum == 0) return 1;
        if (curSum < 0 || index > arr.length - 1) return 0;

        int take = helper(index + 1, curSum - arr[index]);
        int skip = helper(index + 1, curSum);
        
        return skip + take;
    }
    
}

public static void main(String[] args) {
    CountSubsetSumBruteForce test1 = new CountSubsetSumBruteForce(new int[] {1,2,3,3});
    System.out.println(test1.solveCountSubsetSum(6));
}

/*
Question:

Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples: 

Input: arr[] = {1, 2, 3, 3}, X = 6 
Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}

Input: arr[] = {1, 1, 1, 1}, X = 1 
Output: 4 

Solution
In this file the knapSack brute force approach is chosen

Time Complexity:

Space Complexity:

*/