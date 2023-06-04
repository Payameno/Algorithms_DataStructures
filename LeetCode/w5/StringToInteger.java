import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
  public int myAtoi(String s) {
    int len = s.length();
    double num = 0;
    int i = 0;
    boolean positive = false;
    boolean negative = false;

    //pass white spaces
    while(i<len && s.charAt(i)==' ') {
      i++;
    }

    if(i<len && s.charAt(i) == '+') {
      positive = s.charAt(i) == '+';
    }

     if(i<len && s.charAt(i) == '-') {
      negative = s.charAt(i) == '-';
    }

    if (positive || negative) {
      i++;
    }

    while(i<len && s.charAt(i)>= '0' && s.charAt(i) <= '9') {
      num = num*10 + (s.charAt(i) - '0');
      i++;
    }

    num = negative? -num : num;
    num = (num>Integer.MAX_VALUE)? Integer.MAX_VALUE : num;
    num = (num<Integer.MIN_VALUE)? Integer.MIN_VALUE : num;

    return (int) num;
  } 
}
