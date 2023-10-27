class Solution {

    int[] arr;

    public int[] searchRange(int[] nums, int target) {

        arr = nums;
        int[] res = new int[] {-1,-1};
        res[0] = findLeft(target);
        res[1] = findRight(target);
        return res; 
        
    }

    private int findLeft(int target) {
        //Define pointers
        int L = 0, R = arr.length - 1;

        //Define the middle point
        int M = L + (R - L) / 2;

        while (L + 1 < R) {
            if (target < arr[M]) {
                R = M;
            } else {
                L = M;
            }

            if (arr[L] == target) return L;
            if (arr[R] == target) return R;
            return -1;
        }
    }

    private int findRight(int target) {
        //Define pointers
        int L = 0, R = arr.length - 1;

        //Define the middle point
        int M = L + (R - L) / 2;

        while (L + 1 < R) {
            if (target <= arr[M]) {
                R = M;
            } else {
                L = M;
            }

            if (arr[R] == target) return L;
            if (arr[L] == target) return R;
            return -1;
        }
    }
}

/*
Time complexity:
O(logn)

Space complexity:
O(1)

 Example 1:

Input: nums = [5,7,7,8,8,8,8,10], target = 8
                           L
                           M
                              R

Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */