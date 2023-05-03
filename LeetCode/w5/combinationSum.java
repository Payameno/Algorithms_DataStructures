import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class combinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //solving combination sum using backTrack

    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);
    backTrack(list,new ArrayList<>(), candidates, target, 0);
        return list;
  }

  private void backTrack(List<List<Integer>> list, List<Integer> comList, int[] nums, int remain, int start) {
  
    if (remain<0) {
      return;
    }
    else if (remain==0) {
        list.add(new ArrayList<>(comList));
    } else {

      for (int i=start; i<nums.length; i++) {
        comList.add(nums[i]);
        backTrack(list, comList, nums, remain-nums[i], i);
        comList.remove(comList.size()-1);
      }

    }
  
  }
}