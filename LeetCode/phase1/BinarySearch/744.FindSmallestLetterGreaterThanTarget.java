class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

      //base
      int len = letters.length;
      if (target < letters[0] || target >= letters[len - 1]) return letters[0];
      
      //define pointers
      int leftIdx = 0, rightIdx = len - 1;

      while (leftIdx + 1 < rightIdx) {

        int midIdx = (rightIdx-leftIdx)/2;

        if (letters[midIdx] > target) {
          rightIdx = midIdx;
        } else {
          leftIdx = midIdx;
        }

      }

      return letters[rightIdx];
        
    }
    
}

/*
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "d"
 * 
 * Time complexity: O(logn)
 */