import java.util.HashMap;

class Solution {

    private char[] dig_arr;
    List<String> res = new LinkedList<>();

    private Map<Character, String> phone = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
      }};

    public List<String> letterCombinations(String digits) {

      //convert String to array of characters : digits = "23" -> ['2', '3']
      dig_arr = digits.toCharArray();

      if (dig_arr.length != 0) {
        helper(0, new StringBuilder());
      }

      return res;
        
    }

    private void helper(int index, StringBuilder sb) {

      if (sb.length() == dig_arr.length) {
        res.add(sb.toString());
        return;
      }
  

      char curDig = dig_arr[index];
      String chars = phone.get(curDig);

      for (char character : chars.toCharArray()) {
        sb.append(character);
        helper(index+1, sb);
        sb.setLength(sb.length()-1);
      }

    }

}

/*
 * Input: digits = "23"
   Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

   res []
            ------------
                            root
               a              b               c
            ad  ae  af     bd be bf       cd ce cf

            ------------
            Time complexity: as input grows time complexity grows exponentially
            O(b^n) where b is the maximum letter of a digit on the phone book
            and n is the number of digits
------------
            Space complexity - Maximum space needed for res call stack
            it's the number of combinations stored in res, which is equal to 
            the length of input string n
            O(n)
            ------------
 */

