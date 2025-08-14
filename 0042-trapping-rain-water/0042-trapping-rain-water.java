
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // Update left max
                } else {
                    waterTrapped += (leftMax - height[left]);  // Store trapped water
                }
                left++;  // Move left pointer
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // Update right max
                } else {
                    waterTrapped += (rightMax - height[right]);  // Store trapped water
                }
                right--;  // Move right pointer
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height)); // Output: 6
    }
}

