//3. Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest substring without repeating characters.

// Input: s = "abcabcbb" || "abba" || "abcbad"
//                                       L
//                                         R
//      maxLength
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

//solution: Sliding window approach

function lengthOfLongestSubstring(s: string): number {

  //We would need to map every character to an index
  const charMap: Map<string,number> = new Map();

  let right = 0;
  let left = 0;
  let maxLength = 0;

  while (right < s.length) {

        const char = s[right];

        //Char already exists
        //second condition to make sur
        if (charMap.has(char) && charMap.get(char) >= left) {
          left = charMap.get(char) + 1
        }

        charMap.set(s[right],right);
        maxLength = Math.max(maxLength, right - left + 1);
        right++;
        
      }
      return maxLength;
}; 


// && charMap.get(char) >= left