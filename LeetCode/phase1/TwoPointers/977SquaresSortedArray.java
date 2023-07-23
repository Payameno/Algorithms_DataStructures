class solution {

    public int[] sortedSquares(int[] nums) {
    
      //find the middle point
      int mid = 0;
      int n = nums.length;

      //define the result array
      int[] result = new int[n];

      for (int i = 0; i < n; i++) {

        mid = i;
        if (nums[i] >= 0) {
          break;
        }

      }

      //define pointers
      int l = mid - 1, r = mid, index = 0;

      while (l >= 0 && r <= n - 1) {

        int left = nums[l] * nums[l];
        int right = nums[r] * nums[r];

        if (right < left) {

          result[index] = right;
          r++;

        } else {

          result[index] = left;
          l--;

        }

        index++;

      }


      while (l >= 0) {
        result[index++] = nums[l] * nums[l];
        l--;
      }

      while (r <= n -1) {

        result[index++] = nums[r] * nums[r];
        r++;

      }

      return result;
      
    }

}

//Input: nums = [-7,-3,2,3,11]
//               l          r