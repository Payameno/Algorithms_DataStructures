package BinarySearch;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

    }

}

/*
Time complexity:

Space complexity:

An integer a is closer to x than an integer b if:
(Absolute value minus target integer is less than the other integer,
or if they are the same, the value of a is less than b)

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

 */