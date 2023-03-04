function majorityElement(nums: number[]): number {

  const count: {[key:number]: number} = {};
  const halfPoint = nums.length/2;

  nums.forEach((number) => {
    count[number] = (count[number] || 0) + 1;
  })

  for ( let property in count) {
    if (count[property] > halfPoint) {
      return parseInt(property);
    }
  }

};