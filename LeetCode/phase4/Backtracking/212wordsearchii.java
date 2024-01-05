import java.util.*;

class Solution {

    class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }

    int m, n;
    TrieNode trie = new TrieNode();
    List<String> res = new LinkedList<>();
    char[][] board;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        //Insert the words into the trie
        for (String word : words) {
            insertTrie(word);
        }

        //DFS for each character in the trie
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                dfs(i,j,new StringBuilder(),trie);
            }
        }
        return res;
    }

    private void dfs (int row, int col, StringBuilder sb, TrieNode curTrie) {
        
        //Base
        if (row < 0 || m <= row || col < 0 || n <= col) return;
        if (visited[row][col]) return; // check if visited
        char curChar = board[row][col];
        if (!curTrie.map.containsKey(curChar)) return;
        
        sb.append(curChar);//Add this character to the string builder
        curTrie = curTrie.map.get(curChar);
        visited[row][col] = true; //Set as visisted

        //Add current string to the res if it is a word
        if (curTrie.isWord) {
            res.add(sb.toString());
        }

        //DFS four directions
        dfs(row - 1, col,sb, curTrie); // top
        dfs(row + 1, col,sb, curTrie); // bottom
        dfs(row, col - 1,sb, curTrie); //left
        dfs(row, col + 1,sb, curTrie); //right

        //BackTrack
        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
    }

    private void insertTrie(String word) {
        char[] arr = word.toCharArray();
        TrieNode curNode = trie;

        for (char curChar : arr) {
            if (!curNode.map.containsKey(curChar)) {
                curNode.map.put(curChar, new TrieNode());
            }
            curNode = curNode.map.get(curChar);
        }

        curNode.isWord = true;
    }

}

/*
Time complexity:
The dominating factor is the DFS traversal, so the overall time complexity is 
O(M * N * 4^L).
Explanation:
O(N * M) for trie insertion where N the length of words array and M longest word
+ 
O(M * N * 4^L) for DFS traversal 
DFS traversal time complexity:
The DFS traversal visits each cell once, and in the worst case, it can explore the entire board (M * N).
In each DFS call, the time complexity is O(4^L), where L is the length of the longest word in the trie.


Space complexity: O(m * n + (N * L) + L)
O(N * L) for the trie (where N is the number of words, and L is the length of the 
longest word.)
+ O(m * n) for the visited array + O(L) for the StringBuilder.



Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */