import java.util.*;

class Solution {

    char arr[];
    List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        arr = s.toCharArray();

        //Base
        if (12 < arr.length) return res;
        dfs(0, new LinkedList<>());
        return res;
    }

    private void dfs(int index, List<String> curComb) {

        int size = curComb.size();
        if (size > 4) return;

        //Add the combination to res if met all condt
        if (size == 4 && index == arr.length) {
            String combination = convertIpStr(curComb);
            res.add(combination);
        }

        StringBuilder str = new StringBuilder();
        for (int i = index; i < arr.length && i < index + 3; i++) {
            //Add the current character
            str.append(arr[i]);
            //check if it's valid
            if (!checkValid(str.toString())) break;
            curComb.add(str.toString()); //Add the combination to a list
            dfs(i + 1, curComb);

            //Backtracking
            curComb.remove(curComb.size() - 1);
        }
    }

    private boolean checkValid (String str) {
        if (str.charAt(0) == '0' && str.length() > 1) return false;
        return Integer.parseInt(str) <= 255;
    }

    private String convertIpStr(List<String> str) {

        StringBuilder sb = new StringBuilder();
        for (String item : str) {
            sb.append(item);
            sb.append('.');
            //199.23.24.55.
        }

        return sb.substring(0, sb.length() - 1);
    }

}

/*
Time complexity:
The depth of the recursive call stack is 4 while we iterate 3 times for each combination
therfore:  0(3^4) or O(81) which means time grows exponentially with input increate and rate of 81 

Space complexity:
O(n)  : for the arr of characters created in the beginning.
Since the maximum depth of the recursion is constant (4 in this case), 
and the maximum size of curComb is also constant (4 elements), 
these do not contribute to the overall space complexity in terms of input size.


Solution: A depth-First recursion with backtracking 
to examin all possible solutions

Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

Constraints:
1 <= s.length <= 20 Note: the length cannot be longer than 12 anyways
s consists of digits only.

 */