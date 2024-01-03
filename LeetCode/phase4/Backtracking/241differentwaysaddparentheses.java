import java.util.*;

class Solution {

    final private char MULTUPLICATION = '*';
    final private char ADDITION = '+';
    final private char SUBTRACTION = '-';
    char[] expressionArr;
    Set<Character> operatorSet = new HashSet<>();
    String expression;

    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        this.expressionArr = expression.toCharArray();
        //Add operators to the set
        operatorSet.add(MULTUPLICATION);
        operatorSet.add(ADDITION);
        operatorSet.add(SUBTRACTION);

        return dfs(0, expressionArr.length - 1);
    }

    private List<Integer> dfs(int strIdx, int endIdx) {
        List<Integer> res = new LinkedList<>();

        for (int i = strIdx; i < endIdx; i++) {
            if (operatorSet.contains(expressionArr[i])) {
                List<Integer> leftList = dfs(strIdx, i - 1);
                List<Integer> rightList = dfs(i + 1, endIdx);
                /*
                 2*3-4*5
                 leftList [2]
                 rightList [-17, -5]

                 */
                for (int num1 : leftList) {
                    for (int num2 : rightList) {
                        int finVal = calculate(num1, num2, expressionArr[i]);
                        res.add(finVal);
                    }
                }

            }
        }

        //Leaf node, add to the list to be returned in the recursive stack
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression.substring(strIdx, endIdx + 1)));
        }

        return res;
    } 

    private int calculate(int num1, int num2, char operator) {

        switch (operator) {
            case MULTUPLICATION:
                return num1*num2;
            case ADDITION:
                return num1+num2;
            case SUBTRACTION:
                return num1-num2;
            default:
                return -1;
        }

    }

}

/*
Time complexity:
O(2^n)
Each recursive call splits the array into two parts

Space complexity:
O(2^n) major contributing factor is the length of the res List where it holds the result of
all combinations

Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

Constraints:
1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].

 */