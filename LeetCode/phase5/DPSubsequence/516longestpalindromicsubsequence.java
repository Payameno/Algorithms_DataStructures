class Solution {

    public int longestPalindromeSubseq(String s) {
        //String "bbbab"
        char[] arr = s.toCharArray();
        int N = arr.length;

        //Each coordinate represents an index in the char arr
        int[][] cache = new int[N][N];

        for(int i = N - 1; 0 <= i; i--){
            cache[i][i] = 1;
            for(int j = i + 1; j < N; j++){
                if(arr[i] == arr[j]){
                    cache[i][j] = 2; // the length between i&j
                    if (i+1<j){
                        //When there are characters between the two
                        cache[i][j] += cache[i+1][j-1];
                    }
                } else {
                    cache[i][j] = Math.max(cache[i+1][j], cache[i][j-1]);
                    /*bbbafghjkmcc  number 1  length = 2
                        ^        ^
                         ---------
                    (1)  [        ] (i+1 -> j) 

                    *bbbbbqwertyc   number 2 length=3
                       ^        ^
                        ---------
                    (2) [        ]  (i -> j-1)

                    */
                }
            }
        }
        return cache[0][N-1];
    }

}

/*
 Time complexity:

 Space complexity:

Note:
A subsequence is a sequence that can be derived from another
sequence by deleting some or no elements without changing the
order of the remaining elements.

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 
Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters.
 */