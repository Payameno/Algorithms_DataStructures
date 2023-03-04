/**
 * The knows API is defined in the parent class Relation.
 * isBadVersion(version: number): boolean {
 *     ...
 * };
 */

var solution = function(isBadVersion: any) {

  return function(n: number): number {

    let left = 1, right = n, res = 1;

    while (left <= right) {
      const middle = Math.floor((right+left)/2);
      if (!isBadVersion(middle)) {
        if (isBadVersion(middle+1)){
          return middle+1;
        }
        left = middle+1;
      } else {
        right = middle-1;
      }
    }
    return res;
  };
};