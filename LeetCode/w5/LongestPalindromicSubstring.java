public class LongestPalindromicSubstring {

  int maxLen = 0;
  int left = 0;

  public String longestPalindrome(String s) {
    char[] input = s.toCharArray();

    for (int i=0;i<s.length();i++) {
      expand(input, i, i);
      expand(input, i, i+1);
    }
    return s.substring(left, left+maxLen);
  }

  private void expand (char[] input, int j, int k) {
    while(k<input.length && j>=0 && input[j]==input[k]) {
      j--;
      k++;
    }

    if(maxLen<k-j-1) {
      maxLen = k-j-1;
      left = j+1;
    }
  }

}

/*
 * Input: s = "babad"
 * Input: s = "babbad"
   Output: "bab"
 */