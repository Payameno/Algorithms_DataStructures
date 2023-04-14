package W4;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

      int[] result = new int[nums.length];

      //left pass
      int runningProduct = 1;
      
        for (int i = 0; i<nums.length; i++) {
          result[i] = runningProduct;
          runningProduct = runningProduct*nums[i];
        }

      //right pass
      runningProduct = 1;
      
        for (int i=nums.length-1; i>=0;i--) {
          
          result[i] = result[i]*runningProduct;
          runningProduct = runningProduct*nums[i];
        }
        
        return result;
    }

}