public class ReorderData {

  public String[] reorderLogFiles(String[] logs) {

    Arrays.sort(logs, (log1,log2) -> {

      //lambda expression to sort

      //split logs to identifier and content
      String[] arr1 = splitStr(log1);
      String[] arr2 = splitStr(log2);

      //check whether anyof the two are numbers
      boolean isNum1 = isNum(arr1[1].charAt(0));
      boolean isNum2 = isNum(arr2[1].charAt(0));
      
      if (isNum1 && isNum2) return 0;
      else if (isNum2) return -1;
      else if (isNum1) return 1;

      boolean sameContent = arr1[1].equals(arr2[1]);

      if (sameContent) return arr1[0].compareTo(arr2[0]);

      return arr1[1].compareTo(arr2[1]);

    });
  
    return logs;
  }

  private String[] splitStr(String arr) {
    return arr.split(" ", 2);
  }

  private boolean isNum(char curChar) {
    return '0' <= curChar && curChar <= '9';
  }

}

/*
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */