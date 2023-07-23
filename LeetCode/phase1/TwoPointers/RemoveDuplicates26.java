import java.util.List;

class Solution {

    public int removeDuplicates(int[] nums) {

      int n = nums.length;
        
      //base
      if (n<3) return n;

      //Pointers definition
      int l = 0, r = 1;

      //value map
      List<Integer> map = new ArrayList<>();

      //solution
      while (r<n) {

        if (nums[l] == nums[r]) {
          if (map.indexOf(nums[l]) != -1) {
            map.add(nums[l]);
          }
          r++;
          l++;
        } else {

          if (map.indexOf(nums[r]) != -1) {
            map.add(nums[r]);

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            r++;
            l++;
          }

          if (map.indexOf(nums[l]) != -1 && map.indexOf(nums[r]) != -1) {
            r++;
          }

        }

      }

      return map.size();

    }

}

//Time complexity O(n)