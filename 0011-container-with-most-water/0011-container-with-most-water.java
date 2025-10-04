class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, minHeight * (right - left));

            if (height[left] < height[right]) {
                left++; // Move left pointer
            } else {
                right--; // Move right pointer
            }
        }

        return maxWater;
    }
}
