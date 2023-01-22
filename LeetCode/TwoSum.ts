function twoSum(nums: number[], target: number): number[] {
  //Hashmap
  const map = new Map();

  for (let i = 0; i < nums.length; i++) {
    const value = target - nums[i];
    if (map.has(value)) {
      return [map.get(value), i];
    } else {
      map.set(nums[i], i);
    }
  }
  return[];
}