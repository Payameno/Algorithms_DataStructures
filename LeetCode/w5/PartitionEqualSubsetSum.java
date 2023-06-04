public class PartitionEqualSubsetSum {
  int[] arr;
  Boolean[][] cache;

  public boolean canPartition(int[] nums) {
    int sum = 0;
    arr = nums;
    for (int el:nums) {
      sum += el;
    }
    if (sum%2!=0) return false;
    
    
    int half = sum/2;
    cache = new Boolean[nums.length][half+1];

    //funcion to recursively evaluate all idxsibilities
    return helper(half, 0);
  }

  private boolean helper(int sum, int idx) {

    if (sum<0 || idx>=
    arr.length) return false;
    if (sum==0) return true;

    if(cache[idx][sum] != null) {
      return cache[idx][sum];
    }

    boolean take = helper(sum-arr[idx], idx+1);
    boolean skip = helper(sum, idx+1);

    cache[idx][sum] = take || skip;
    return cache[idx][sum];
  }
}
