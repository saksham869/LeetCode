class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWindow = Integer.MAX_VALUE;  // Minimum window length
        int currentSum = 0; 
        int low = 0, high = 0;  // Two pointers

        while (high < nums.length) {
            // Expand the window by adding nums[high]
            currentSum += nums[high];
            high++;

            // Shrink the window while sum >= target
            while (currentSum >= target) {
                int currentWindowSize = high - low;
                minLenWindow = Math.min(minLenWindow, currentWindowSize);

                // Remove nums[low] and move left pointer
                currentSum -= nums[low];
                low++;
            }
        }

        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}
