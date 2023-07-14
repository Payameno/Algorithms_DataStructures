import java.util.HashMap;
import java.util.Map;

class Solution {

    public int leastInterval(char[] tasks, int n) {

      int[] count = new int[26];
      int max = 0;
      int maxCount = 0;

      for (char c : tasks) {
        count[c-'A']++;
        max = Math.max(max, count[c-'A']);
      }

      for (int i : count) {
        if (i == max) maxCount++;
      }

      return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }

}