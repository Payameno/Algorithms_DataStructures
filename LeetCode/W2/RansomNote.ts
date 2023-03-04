function canConstruct(ransomNote: string, magazine: string): boolean {

  const charObj: {[key: string]: number} = {};

  for (let char of magazine) {
    charObj[char] = (charObj[char] || 0) + 1;
  }

  for (let character of ransomNote) {
    if (!charObj[character]) {
      return false;
    }
    charObj[character] = charObj[character] - 1;
  }

  return true;
};

//IN typescript and Javascript, Object data type is how we can implememt hash tables
//Input: ransomNote = "aa", magazine = "aab"