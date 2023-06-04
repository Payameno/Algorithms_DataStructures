import java.util.ArrayList;
import java.util.List;

public class PhoneNumberLetterCombination {
  
  public List<String> letterCombinations(String digits) {

    List<String> result = new ArrayList<>();
    if(digits == null || digits.length() == 0) return result;

    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder combination = new StringBuilder();
    Backtrack(digits, result, map, combination, 0);
    return result;

  }

  //Backtracking method to recursively populate the result
  private void Backtrack(String digits, List<String> result, String[] map,StringBuilder combination, int startidx) {
    
    if(startidx==digits.length()) {
      result.add(combination.toString());
    } else {
      String letters = map[digits.charAt(startidx) - '0'];
      for (char letter:letters.toCharArray()) {
        combination.append(letter);
        Backtrack(digits, result, map, combination, startidx+1);
        combination.deleteCharAt(combination.length()-1);
      }
    }
  }

}
