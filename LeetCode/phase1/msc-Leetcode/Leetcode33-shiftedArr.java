package msc-Leetcode;

class Solution {
  public int search(int[] shiftArr, int num) {

    int left = 0; 
    int right = shiftArr.length - 1;

    while (left <= right) {
      int mid = (right + left) / 2;
      
      if (shiftArr[mid] == num) return mid;
      if (shiftArr[left] == num) return left;
      if (shiftArr[right] ==num) return right;
      
      if (shiftArr[left] <= shiftArr[mid]) {
        
        if (num < shiftArr[mid] && num > shiftArr[left]) {
          
          right = mid - 1;
          
        } else {
          
          left = mid + 1;
          
        }
        
      } else {
        
        if (num > shiftArr[mid] && num < shiftArr[right]) {
          
          left = mid + 1;
          
        } else {
          
          right = mid - 1;
          
        }
        
      }
        
      }
        return -1;
    }
    
}