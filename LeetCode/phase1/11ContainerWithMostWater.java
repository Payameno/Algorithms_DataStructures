class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int L = 0, R = height.length - 1, area = 0;

        while (L < R) {
            int w = R - L;
            int h = Math.min(height[L],height[R]);
            area = Math.max(area, w*h);

            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }

        }

        return area;
        
    }

}
