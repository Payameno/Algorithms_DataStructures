import java.util.*;

class Solution {

    char[] sArr;
    String str;
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        this.str = s;
        sArr = s.toCharArray(); //convert to characters
        helper(0, new LinkedList<>());
        return res;
    }

    private void helper(int index, List<String> comb) {

        //valid combinations are added to the loop when iteration is complete
        if (index == str.length()) {
            List<String> temp = new LinkedList<>(comb);
            res.add(temp);
            return;
        }

        for (int i = index; i < sArr.length; i++) {
            if (!isPalindrome(index, i)) continue;
            comb.add(str.substring(index, i + 1));
            helper(i + 1, comb);

            //Backtracl
            comb.remove(comb.size() - 1);
        }

    }

    private boolean isPalindrome(int left, int right) {
        while (left <= right) {
            if (sArr[left] != sArr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

}

/*
 Time complexity:
 O(N*2^N)
 O(N) worst case time comp of isPalindrome function (where string is a palindrome)


 Space complexity:
 O(N) where N is the length of the string
 O(N*2^N)
 1- O(N) call stack
 2- O(N) worst case combination in comb
 3- res worst case can be exponential


Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
 
Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.

 */