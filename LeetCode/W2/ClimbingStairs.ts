function climbStairs(n: number): number {

  let cache: number[] = [];
  if (n<=2) return n;

  if (!cache[n]) cache[n] = climbStairs(n-2) + climbStairs(n-1);
  
  return cache[n];
};

function climbStairsLoop(n: number): number {

  let cache: number[] = [0,1,2];

  if (n>=3) for (let i = 3; i <= n; i++) {
    cache[i] = cache[i-2] + cache[i-1];
  }
  
  return cache[n];
};

// Loop and recurrence both have time complexity of 0(N) but space complexity is better in loop