class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum = 0;
        // Find the maximum value in nums
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int maxLength = 0;
        int currentLength = 0;
        // Find the longest contiguous subarray of maxNum
        for (int num : nums) {
            if (num == maxNum) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }
        return maxLength;
    }
}
