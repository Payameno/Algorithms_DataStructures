function containsDuplicate(nums: number[]): boolean {

  let elementsObj: {[key: number]: number} = {}
  let result: boolean = false;

  nums.forEach((element) => {
    elementsObj[element] = elementsObj.hasOwnProperty(element)? elementsObj[element]+1 : 1;
    if (elementsObj[element] === 2) result = true;
  })
  return result;
};
