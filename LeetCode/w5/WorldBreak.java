import java.util.HashSet;
import java.util.Set;

/*
 * Time complexity = O(n^3)
 */

public class WorldBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(0, s, new HashSet<>(wordDict));
    }

    private boolean wordBreak(int p, String s, Set<String> dict) {
      int stringLeng = s.length();

      if (p==stringLeng) {
        return true;
      }

      for (int i=p+1; i<=stringLeng;i++) {
        if (dict.contains(s.substring(p, i)) && wordBreak(i, s, dict)) {
          return true;
        }
      }
      
      return false;
    }

}
