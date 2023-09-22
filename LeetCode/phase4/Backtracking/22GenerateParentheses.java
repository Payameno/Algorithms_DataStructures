import java.util.LinkedList;
import java.util.List;

class Solution {

    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {

        dfs(new StringBuilder(), 0, n);
        return res;
    }

    private void dfs(StringBuilder sb,int closing,int opening) {

        if (opening == 0 && closing == 0) {
            res.add(sb.toString());
        }

        if (opening > 0) {
            sb.append('(');
            dfs(sb, closing + 1, opening - 1);
            sb.setLength(sb.length() - 1);
        }

        if (closing > 0) {
            sb.append(')');
            dfs(sb, closing - 1,opening);
            sb.setLength(sb.length() - 1);
        }
        
    }

}

/*
Time complexity:
n = N
Ex n = 4
 Slots: -, -, -, -
 O(2^n), there are two possiblities for 4 slots, 
 however it can never start with
 a closing parantheses. with n elements this would be trivial

 Space complecity:
 O(2^n)
 SpringBUilder will occupy  O(2^n) space at given time
 while res will have O(2^n) combinations stored
*/

