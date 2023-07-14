class solution {
  //Integer class type to allow null values for non-existing indices
  Integer[] cache;

  public int integerBreak(int n) {
    cache = new Integer[n+1];
    return dfs(n);
  }

  //top to bottom approach

  private int dfs(int n) {
    
    if (n < 2) return 0;

    if (cache[n] != null) return cache[n];

    int maxProcuct = 0;

    for (int i = 1; i < n; i++) {
      int currentMaxProduct = Math.max(dfs(n-i), n-i);
      maxProcuct = Math.max(maxProcuct, currentMaxProduct*i);
    }
    cache[n] = maxProcuct;
    return maxProcuct;
  }

}