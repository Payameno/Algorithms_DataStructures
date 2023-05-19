public class SortColors {

  public void sortColors(int[] nums) {
    //sort using three pointers
    int low = 0, mid = 0,high = nums.length-1;

    while(mid<=high) {
      if(nums[mid]==0) {
        swap(nums, low, mid);
        low++;
        mid++;
      } else if (nums[mid]==2) {
        swap(nums, mid, high);
        high--;
      } else {
        mid++;
      }

    }
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

}