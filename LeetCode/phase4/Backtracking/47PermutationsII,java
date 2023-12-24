import java.util.*;

class Solution {

    List<List<Integer>> res = new LinkedList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Map<Integer, Integer> hm = new HashMap<>();
        //Map the values of nums
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        helper(hm, new LinkedList());

        return res;

    }

    private void helper(Map<Integer, Integer> hm, List<Integer> curComb) {
        
        //HashSet to collect unique integers(Paths), hashMap key set is fed to this set
        Set<Integer> set = new HashSet(hm.keySet());

        //All numbers used in the path
        if (hm.isEmpty()) {
            List<Integer> temp = new LinkedList(curComb);
            res.add(temp);
            return;
        }

        for (int number : set) {
            //Remove the used number from HashMap
            if (hm.get(number) == 1) {
                hm.remove(number);
            } else {
                hm.put(number, hm.get(number) - 1);
            }

            curComb.add(number);
            helper(hm, curComb);

            //Backtracking, reverse the last changes
            curComb.remove(curComb.size() - 1);
            hm.put(number, hm.getOrDefault(number, 0) + 1);

        }

        
    }

}

/*
Time complexity:
Worst case where there is little repition
O(NxN!)

If there are fewer duplicates, number of iterations of set might be insignificant
and thereforer the time complexity might be O(N!)

Space complexity:
O(N!)
Factors that influence the space complexity are:

-HashMap (worst case can contain N elements) -no duplicates-
-curComb O(N) where N is the size of the input
-res the list can use space with O(N!) rate, because in the worst case
the method generates N! permutations
-Recursive call stack, in the worst case could be O(N)

Solution: 
Duplicates inputs but need unique output
Therefore for a path definition we use a map to track each integer with the number of repition

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]


Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
 
 */