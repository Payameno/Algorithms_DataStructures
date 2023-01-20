function addUpton(n) {
  let sum = 0;
  for(let i=0; i <= n; i++ ){
    sum += i;
  }
  return sum;
}
let t1 = performance.now();
console.log(addUpton(100000000));
let t2 = performance.now();
console.log(`Time Elapsed: ${(t2 - t1)/1000} seconds`);