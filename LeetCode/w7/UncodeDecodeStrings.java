
public class UncodeDecodeStrings {
  
  char delimiter = '#';

  public String encode(List<String> str) {

    StringBuilder sb = new StringBuilder();

    for (String string : str) {
      sb.append(str.length());
      sb.append(delimiter);
      sb.append(string);
    }

    return sb.toString();
  }

  public String decode(String str) {

    char[] strArr = str.toCharArray();
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
  
    for (int i = 0; i<str.length(); i++){

      while(strArr[i]!=delimiter) {
        sb.append(strArr[i++]);
      }
      i++;

      int strLen = Integer.valueOf(sb.toString());
      int end = i+strLen;

      sb = new StringBuilder();
      
      while(i<end) {
        sb.append(strArr[i++]);
      }
      i--;

      res.add(sb.toString());

    }

    return res;

  }

}

/* 
 * Input = ["Hello", "World"]
 * Output = ["Hello", "World"]
 * 
 * Process = "5#Hello5#World"
*/