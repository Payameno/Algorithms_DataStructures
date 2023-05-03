import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class permutations {

  public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        backTrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
  }

  private void backTrack(List<List<Integer>> list, List<Integer> permList ,int[] nums, boolean[] used) {
    if (permList.size()==nums.length) {
      list.add(new ArrayList<>(permList));
    } else {
        for (int i=0; i<nums.length; i++) {
          if (used[i]) continue;
          permList.add(nums[i]);
          used[i] = true;
          backTrack(list, permList, nums, used);
          used[i] = false;
          permList.remove(permList.size()-1);
        }
    }
  }
}
