function isValid(s: string): boolean {
  if (s.length % 2 != 0) return false; //["[","]", "{"]

  //key value object types are deined as below
  const matching: {[string: string]: string} = {"{": "}", "[": "]", "(":")"};

  let stack: string[] = [];

  for (const char of s) {
    if(matching[char]) stack.push(char);
    else if (char !== matching[stack[stack.length - 1]]) return false;
    else stack.pop();
  }
  return stack.length === 0;
};