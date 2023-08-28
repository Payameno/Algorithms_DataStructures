import java.util.ArrayList;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
      int len = numbers.length;
      int L = 0, R = len-1;

      while (L<R) {
        int curSum = numbers[L] + numbers[R];

        if (curSum==target) {
          return new int[] {L+1, R+1};
        } else if (curSum>target) {
          R--;
        } else {
          L--;
        }

      }
      return new int[] {-1,-1};
    }

}

/*
 * Input: numbers = [2,7,11,15], target = 9
 *Output: [1,2]
 */