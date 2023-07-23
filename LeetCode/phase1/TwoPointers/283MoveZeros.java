public class 283MoveZeros {
  
  public void moveZeroes(int[] nums) {

    int len = nums.length;
    
    //base
    if (len<2) return;

    //define pointers
    int l=0,r=1;

    //move zeros
    while (r<len) {
      if(nums[l]!=0) {
        l++;
        r++;
      } else if (nums[r]==0) {
        r++;
      } else {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
      }
    }

  } 

}

/*
 * Input: nums = [1,12,0,0,0]
                    L
                           R

                 [1,0,0,3,12]
                    L 
                        R
                        
                 [1,3,0,0,12]
                       L   R
                  [1,3,12,0,0]
 */