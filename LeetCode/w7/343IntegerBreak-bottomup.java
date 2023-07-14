class solution1 {

  //bottom up DP approach
  
  public int integerBreak(int n) {
    int[] cache = new int[n+1];

    cache[0] = 0;
    cache[1] = 0;
    cache[2] = 1;

  for (int num=3; num <= n; num++) {

    for (int j = 1; j < num; j++) {

      int currentMaxProduct = Math.max(cache[num-j], num-j);
      cache[num] = Math.max(currentMaxProduct*j, cache[num]);

    }

  }

  return cache[n];

  }

}