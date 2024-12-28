class Solution { 
    public int maxArea(int[] height) {
        int maxArea = 0;
        int area = 0;
        int length = height.length;

        int i, j;
        i = 0;
        j = length - 1;

        while (i < j) {
            area = (j - i) * Math.min(height[j], height[i]);
            if (area > maxArea) maxArea = area;
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    } 
}