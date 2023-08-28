import java.util.HashSet;
import java.util.set;

class Solution {

    public int removeDuplicates(int[] nums) {

      int n = nums.length;
        
      //base
      if (n<2) return n;

      //Pointers definition
      int l = 0, r = 1;

      //value set
      HashSet<Integer> set = new HashSet<>();

      //solution
      while (r<n) {

        if (nums[l] == nums[r]) {
          if (!set.contains(nums[l])) {
            set.add(nums[l]);
          }
          r++;
          l++;
        } else {

          if (!set.contains(nums[r])) {
            set.add(nums[r]);

            //swap left with right to form an array without duplicates on the left
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            r++;
            l++;
          }

          //If both pointers are in the list 
          if (set.contains(nums[l]) && set.contains(nums[r])) {
            ++r;
          }

        }

      }

      return set.size();

    }

}

//Time complexity O(n)