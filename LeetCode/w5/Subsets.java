import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backTrack(nums, list, new ArrayList<>(), 0);
    return list;
  }

  private void backTrack(int[] nums ,List<List<Integer>> list, List<Integer> tempList, int start) {
  list.add(tempList);
  for (int i=start; i<nums.length; i++) {
    //in case of duplicates:
   if(i>start && nums[i]==nums[i-1]) continue;
   tempList.add(nums[i]);
   backTrack(nums, list, tempList, i+1);
   tempList.remove(tempList.size() - 1); 
  }  
  }
}
