package W4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    List<Integer> minAmount;  

  public MinStack() {
    stack = new Stack<>();
    minAmount = new ArrayList<>();
  }

  public void push(int val) {
    stack.push(val);

    //keep track of the minimum value
    if (minAmount.isEmpty() || minAmount.get(minAmount.size()-1)>val) {
      minAmount.add(val);
    } else {
      int temp = minAmount.get(minAmount.size()-1);
      minAmount.remove(minAmount.size()-1);
      minAmount.add(val);
      minAmount.add(temp);
    }
  }

  public void pop() {
    int popped = stack.pop();
    int poppedIdx = minAmount.indexOf(popped);
    minAmount.remove(poppedIdx);
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minAmount.get(minAmount.size()-1);
  }

}
