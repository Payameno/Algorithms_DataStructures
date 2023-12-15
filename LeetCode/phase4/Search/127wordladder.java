import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //Define the Queue & Set
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        //Base case
        if (!set.contains(endWord)) return 0;

        //Define the result
        int level = 1;

        //Add the begin word to the queue
        queue.add(beginWord);

        //Loop through the queue
        while(!queue.isEmpty()) {
            int size = queue.size();

            //loop through the breadth
            for (int i = 0; i < size; i++) {
                char[] curStrArr = queue.poll().toCharArray(); //[h,i,t]

                //Loop through current String
                for (int j = 0; j < curStrArr.length; j++) {
                    char oldChar = curStrArr[j];

                //Loop through 26 characters to find a match
                for (char character = 'a'; character <= 'z'; character++) {

                    //Swap the old with new character
                    curStrArr[j] = character; //[a,i,t]
                    String curStr = new String(curStrArr); //Convert back to string

                    //Chec if the endWord is reached
                    if (curStr.equals(endWord)) {
                        return level + 1; //Return the count of level plus the endWord
                    }
                    
                    //Check if it exists in the set
                    if (set.contains(curStr)) {
                        queue.add(curStr); //Add the next sequence to the queue
                        set.remove(curStr); //remove the sequenece word from the set
                    }

                }
                curStrArr[j] = oldChar; //Convert string back to the original
                }
            }
            level++; //Add to the number of words
            }
        return 0;
    }

}

/*
Solution:
A breadth-First Seach solution, a LinkedList used with a queue interface and a set to store the elemtns of 
the wordList, starting from the beginWord each level's sequence(s) is/are added to the queue and then from the queue
elelemt(s) is/are polled to check whether there is another sequence(s). 
Levels are counted in each iteration to calculate the shortest transormation

Time complexity:
O(MxN)
While loop, in the worst case all words in the list are added to the queue. O(N)
Iteration through each word's length also takes O(M) where M is the length of the word

Space complexity:
Queue in the worst case can all the items in the worldList (N)
Therefore O(N)


Example 1:
Transformation from hit to cog
BFS:               Queue                   Poll
Level 1:   hit      hit                    hit
           |
Level 2:   hot      hot                    hot
          /   \
Level 3: dot  lot   dot, lot               dot
         |      |
Level 4: dog    log  lot, dog,log          lot
           \   /
Level 5:   cog       dog,log,cog


Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */