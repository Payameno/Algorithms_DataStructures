import java.util.Arrays;
class solution1 {
    public String[] reOrderLogFilers(String[] logs) {

        //Sort the array using a lambda expression
        Arrays.sort(logs, (log1, log2) -> {
            //Devide the log into identifier and contents
            String[] arr1 = devide(log1);
            String[] arr2 = devide(log2);

            //Check if log1 or log2 content are numbers
            boolean isNum1 = isNum(arr1[1].charAt(0));
            boolean isNum2 = isNum(arr2[1].charAt(0));

            if (isNum1 && isNum2) return 0;
            else if (isNum1) return 1;
            else if (isNum2) return -1;

            //Both are not numbers -> sort the Strings

            //Do they have the same contnet?
            boolean sameContent = arr1[1].isEqual(arr2[1]);

            //If they have same content then compare the identifiers
            if (sameContent) return arr1[0].compareTo(arr2[0]);

            //If they do not have the same content then simply sort lexicographically
            return arr1[1].compareTo(arr2[1]);
            
        });

        return logs;
    }

    private String[] devide(String str) {
        return str.split(" ", 2);
    }

    private boolean isNum(char character) {
        return '0' <= character && character <= '9';
    }

}

/*
Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Constraints:

1 <= logs.length <= 100
3 <= logs[i].length <= 100
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier.


<<.compareTo()>>

ava, the compareTo method is used to compare two strings lexicographically 
(based on their Unicode values). The method is defined in the java.lang.
String class, and it returns an integer value that indicates the comparison 
result between two strings. Here are the possible return values of the compareTo method:

Negative Value: If the invoking string (the one on which compareTo is called) 
is lexicographically less than the argument string, the method returns a negative value.
 Typically, this value is less than zero, often -1.

Zero: If the two strings are lexicographically equal, the method returns zero. 
This means that both strings have the same sequence of characters.

Positive Value: If the invoking string is lexicographically greater than the 
argument string, the method returns a positive value. Typically, this value is greater 
than zero, often 1.

*/