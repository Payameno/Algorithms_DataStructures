import java.util.HashMap;
import java.util.List;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

      //Map value to frequency
      HashMap<Integer, Integer> bucket1 = new HashMap<>();
      int n = nums.length;

      for (Integer num : nums) {
        bucket1.put(num, bucket1.getOrDefault(num, 0)+1);
      }

      //Map Frequency to array of values with that frequency
      HashMap<Integer, List<Integer>> bucket2 = new HashMap<>();

      for (Integer num : bucket1.keySet()) {
        int freq = bucket1.get(num);

        //Create the key value in memory - if does not exists
        if (!bucket2.containsKey(freq)) {
          bucket2.put(freq, new ArrayList<>());
        }

        bucket2.get(freq).add(num);
      }

      // Define the reuslt array
      int[] res = new int[k];
      
      //Loop down from top possible frequency
      for (int i = n; i > 0; i--) {

          if (bucket2.containsKey(i)) {

            for (Integer num : bucket2.get(i)) {
                res[--k] = num;
                if (k == 0) return res;
            }

          }

      }

      return res;
        
    }

}

/*
 *Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2] 
 */


