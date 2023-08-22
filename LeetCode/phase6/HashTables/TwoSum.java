import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

      HashMap<Integer, Integer> map = new HashMap<>();

      //Map values to index
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
      }

      //Check if there is a pair solion, return index
      for (int i = 0; i < nums.length; i++) {
        int difference = target - nums[i];

        //check if the difference exists as a value with different index
        if (map.containsKey(difference) && map.get(difference) != i) {
          return new int[] {i, map.get(difference)};
        }
      }

      return new int[] {-1,-1};
        
    }

}

/*
 * Input: nums = [2,7,11,15], target = 9
 *                0 1 2  3
 * Output: [0,1]
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109

    One solution: Nested loop - Time complexity: O(n^2)
    Optimal solution: using Hashtable - mapping value to index (retrieval O(1))
    Time complexity : O(n);
 */