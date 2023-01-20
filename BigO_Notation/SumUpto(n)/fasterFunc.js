function addUpton(n) {
  let sum = n*(n+1)/2;
  return sum;
}
let t1 = performance.now();
console.log(addUpton(100000000));
let t2 = performance.now();
console.log(`Time Elapsed: ${(t2-t1)/1000} seconds`);