function longestPalindrome(s: string): number {

  let countObj = {};
  let oddCount: number[] = [];
  let result = 0;

  if (s === "") return 0;
  if (s.length === 1) return result+1;

  //we need an object with each char as key and number of reoccurences
  for (const char of s) {
    //you need to initialize the key first in order to increment it
    countObj[char] = countObj[char] || 0;

    countObj[char] += 1;
  }

  for (let charCount in countObj) {
    let count: number = countObj[charCount];

    if (count%2===0) {
      result += count;
    }
    if (count%2!==0) {
      oddCount.push(count);
      result += count-1;
    }
  }
  return result + (oddCount.length>0? 1 : 0)
};

//"abccccdd"
// aaa
//count = {a: 1, b:1, c:4. d: 2}