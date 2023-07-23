import java.util.HashSet;

public class RemoveDuplicates26Improved {
  
      public int removeDuplicates(int[] nums) {

      int n = nums.length;
        
      //base
      if (n < 2) return n;

      //Pointers definition
      int l = 0, r = 1;

      
      //solution
      while (r<n) {

        if (nums[l] != nums[r]) {
          l++;
          nums[l] = nums[r];
        } 
        r++;

      }

      //k equals pointer position plus one
      return l+1;

    }

}