class Solution {
    //s = "226"
    //     ^
    public int numDecodings(String s) {
        char[] arr = s.toCharArray(); // ['2','2','6']
        int[] cache = new int[arr.length]; //cache = [0, 0, 0]
        int n = cache.length; // n = 3
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] == '0'){
                continue;
            }

            if(i == n - 1){
                cache[i] = 1; //cache[2] = 1  cache = [0, 0, 1]
                continue;
            }

            String str = s.substring(i, i + 2); // str1 = "26", str2= 22
            if(Integer.parseInt(str) > 26){
                cache[i] = cache[i + 1];  //if it was 27 -> cache[1] = 1 (7 & 2)
            }else if(i == n - 2){
                cache[i] = cache[i + 1] + 1; // cache[1] = cache[2] + 1 = 2 (2 c omb: 26 & 2,6) cache = [0, 2, 1]
            }
            else{
                cache[i] = cache[i + 1] + cache[i + 2]; // cache[0] = 3
            }
        }
        return cache[0];
    }
}

/*
 Time complexity:
 0(n) Iteration therough the length of String s to find the total combination possible 

 Space complexity:
 O(n) the size of cache array is proportional to the length of string s

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */