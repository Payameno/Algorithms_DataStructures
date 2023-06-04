public ContainerWater {

  public int maxArea(int[] height) {
    
    if (height.length == 0) return 0;
    int left = 0,right = height.length-1, area = 0;

    while (left < right) {

      //set height/width of the surface
      int w = right-left;
      int h = Math.min(height[left],height[right]);
      area = Math.max(area , w*h);

      if (height[left] < height[right]) {
        left++;
      } else if (height[left] > height[right]) {
        right--;
      } else {
        right--;
        left++;
      }

    }

    return area;
  }

}

/*
 * Input: height = [1,8,6,2,5,4,8,3,7]
   Output: 49
 */