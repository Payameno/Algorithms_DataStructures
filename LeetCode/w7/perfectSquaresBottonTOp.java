public class perfectSquaresBottonTOp {

  //Bottom Up dynamic programimng solution

  public int numSquares(int n) {

    int[] cache = new int[n+1];

    //base
    cache[0] = 0;

    
    for (int num=1; num <= n; num++) {
      
      cache[num] = Integer.MAX_VALUE;

      for (int i = 1; i*i < num; i++) {

        cache[num] = Math.min(cache[num], cache[num - (i*i)] + 1);

      }

    }

    return cache[n];

  }

}
