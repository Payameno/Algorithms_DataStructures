/**
 * Reverse polish notation, examples:
 * 3 + 4" would be written as "3 4 +"e function
 * "5 + 6 * 2". In RPN, this would be written as "5 6 2 * +"
 * Code is done usign a stack, pop top numbers from stack and implement the functions
 */

function evalRPN(tokens: string[]): number {
  //create a stack numnet
  //push numbrers to the stack
  //check for the oprators (switch) implement them for the last two number
  let stack: number[] = [];


  for (let token of tokens) {
    if (!isNaN(Number(token))) {
      stack.push(Number(token));
    } else {
      const operand1 = stack.pop();
      const operand2 = stack.pop();

      switch (token){
        case '+':
         stack.push(operand2 + operand1);
         break;
        case '-':
         stack.push(operand2 - operand1);
         break;
        case '*':
          stack.push(operand2 * operand1);
         break;
        case '/':
          stack.push(Math.trunc(operand2 / operand1));
         break;
      }
    }
  }
  return stack.pop();
};

